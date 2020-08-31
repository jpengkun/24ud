package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.constant.JpushUtils;
import cn.huaruan.ud24.query.dao.UserJpushRelMapper;
import cn.huaruan.ud24.query.entity.Announcement;
import cn.huaruan.ud24.query.entity.UserJpushRel;
import cn.huaruan.ud24.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Api(value = "公告管理",tags = {"公告管理"})
@RestController
@RequestMapping("/woho/announce")
public class AnnouncementController {



    @Autowired
    private JpushUtils jpushUtils;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private UserJpushRelMapper userJpushRelMapper;


    @ApiOperation(value = "推送",notes = "context,type,title必传")
    @RequestMapping(value ="/push",method= RequestMethod.POST)
    public ResultMessage<Object> push(@RequestBody Announcement announcement){
        Assert.notNull(announcement.getContext(),"title不能为空");
        Assert.notNull(announcement.getContext(),"context不能为空");
        //Assert.notNull(announcement.getType(),"type不能为空");
        return announcementService.push(announcement);
    }

    public static void main(String[] args) {
        File file = new File("file.mp4");
        String outPath = file.getAbsolutePath();
        //String str = newFile.getAbsolutePath();
        System.out.println(outPath);
    }

}
