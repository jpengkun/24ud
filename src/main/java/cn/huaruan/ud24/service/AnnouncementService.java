package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.constant.JpushUtils;
import cn.huaruan.ud24.query.dao.AnnouncementMapper;
import cn.huaruan.ud24.query.dao.UserJpushRelMapper;
import cn.huaruan.ud24.query.entity.Announcement;
import cn.huaruan.ud24.query.entity.User;
import cn.huaruan.ud24.query.entity.UserJpushRel;
import cn.huaruan.ud24.query.mapper.UserMapper;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Autowired
    private JpushUtils jpushUtils;

    @Autowired
    private UserJpushRelMapper userJpushRelMapper;

    @Autowired
    private UserMapper userMapper;


    public ResultMessage<Object> push(Announcement announcement) {
        //推送
        //根据类型获取registraionId
        List<UserJpushRel> result = null;
        result = userJpushRelMapper.selectRegistrationIdByUserId(announcement.getUserId());
        if (result.size() == 0 || null == result) {
            return new ResultMessage<>();
        }

        //存放推送id集合
        List<String> list = new ArrayList<>();
        result.stream().
                forEach(item -> {
                    list.add(item.getRegistrationId());
                });
        /*List<String> list = new ArrayList<>();
        list.add("101d855909c506a26b3");
        list.add("18071adc038a900d6d5");*/
        //开一个线程进行推送,提高速度
        new Thread(new BatchSendPush(announcement, list.toArray(new String[list.size()]))).start();
        return new ResultMessage<>().success();
    }


    private class BatchSendPush implements Runnable {

        private Announcement announcement;

        private String[] registraionIds;


        public BatchSendPush(Announcement announcement, String[] registraionIds) {
            this.announcement = announcement;
            this.registraionIds = registraionIds;
        }

        @Override
        public void run() {
            try {
                Map<String, String> map = new HashMap<>(10);
                String registraionId = registraionIds[0];
                User user = userMapper.selectByPrimaryKey(announcement.getFromUserId());
                //推送
                if (announcement.getPushType() == 2) {
                    map.put("type", "2");
                }
                map.put("sound", "default");
                jpushUtils.sendPush(announcement.getTitle(), announcement.getContext(), announcement.getType(), map, registraionIds);
            } catch (APIConnectionException e) {
                e.printStackTrace();
            } catch (APIRequestException e) {
                e.printStackTrace();
            }
        }

        public Announcement getAnnouncement() {
            return announcement;
        }

        public void setAnnouncement(Announcement announcement) {
            this.announcement = announcement;
        }

        public String[] getRegistraionIds() {
            return registraionIds;
        }

        public void setRegistraionIds(String[] registraionIds) {
            this.registraionIds = registraionIds;
        }
    }


}
