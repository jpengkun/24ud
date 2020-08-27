package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Notice;
import cn.huaruan.ud24.service.NoticeService;
import cn.huaruan.ud24.vo.FindNoticeParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@AllArgsConstructor
@Api(tags = "公告管理")
public class NoticeController {

    private final NoticeService noticeService;

    /*@ApiOperation("根据ID获取用户")
    @GetMapping("/{userId}")
    public ResultMessage<User> getUser(@PathVariable String userId) {
        return new ResultMessage<>(noticeService.getUserById(userId));
    }*/

    @ApiOperation("查询所有公告")
    @GetMapping
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<Page<Notice>> findNotice(FindNoticeParam findNoticeParam) {
        return new ResultMessage<>(noticeService.findNotice(findNoticeParam));
    }

    @ApiOperation("添加公告")
    @PostMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_ADD + "')")
    public ResultMessage<Object> addNotice(@RequestBody Notice notice) {
        noticeService.addNotice(notice);
        return new ResultMessage<>();
    }

    @ApiOperation("更新公告")
    @PutMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_UPDATE + "')")
    public ResultMessage<Object> updateNotice(@RequestBody Notice notice) {
        noticeService.updateNotice(notice);
        return new ResultMessage<>();
    }

    @ApiOperation("根据ID删除公告")
    @DeleteMapping
    //@PreAuthorize("hasAuthority('" + AuthorityCodes.USER_DELETE + "')")
    public ResultMessage<Object> deleteNotice(@RequestBody List<String> noticeIds) {
        noticeService.deleteNoticeList(noticeIds);
        return new ResultMessage<>();
    }


}
