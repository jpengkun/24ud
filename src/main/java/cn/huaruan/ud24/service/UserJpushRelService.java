package cn.huaruan.ud24.service;


import cn.huaruan.ud24.application.RequestUtils;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.UserJpushRelMapper;
import cn.huaruan.ud24.query.entity.UserJpushRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJpushRelService {

    @Autowired
    private UserJpushRelMapper userJpushRelMapper;



    public ResultMessage<Object> insertUserJpushRel(UserJpushRel userJpushRel) {
        userJpushRel .setUserId(RequestUtils.getCurrentUser().getUserId());
        //查询当前用户是否有regid
        List<UserJpushRel> regIds = userJpushRelMapper.findByUserId(userJpushRel.getUserId());
        if (null != regIds && regIds.size() > 0){
            userJpushRelMapper.uptateJpushIdByUserId(userJpushRel);
        }else {
            userJpushRel.setId(UUIDUtil.get());
            userJpushRelMapper.insert(userJpushRel);
        }
        return new ResultMessage<>().success();
    }
}
