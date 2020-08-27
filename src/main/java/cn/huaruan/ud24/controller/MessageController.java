package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.PageParam;
import cn.huaruan.ud24.query.entity.Message;
import cn.huaruan.ud24.service.MessageService;
import cn.huaruan.ud24.vo.FindMessageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@AllArgsConstructor
@Api(tags = "系统消息")
public class MessageController {

    private final MessageService messageService;

    @ApiOperation("查询系统消息")
    @GetMapping
    public ResultMessage<Page<Message>> findMessage(FindMessageParam findMessageParam) {
        return new ResultMessage<>(messageService.findMessage(findMessageParam));
    }

    @ApiOperation("删除系统消息")
    @DeleteMapping
    public ResultMessage deleteMessage(@RequestBody List<String> messageIds) {
        messageService.deleteMessage(messageIds);
        return new ResultMessage();
    }

    @ApiOperation("查询单个")
    @GetMapping("/id/{messageId}")
    public ResultMessage findOne(@PathVariable String messageId) {
        return new ResultMessage<>(messageService.getMessage(messageId));
    }

    @ApiOperation("查询单个")
    @GetMapping("/read/{messageId}")
    public ResultMessage read(@PathVariable String messageId) {
        messageService.read(messageId);
        return new ResultMessage();
    }

    @ApiOperation("根据用户id查询未读消息")
    @GetMapping("/userId/{userId}")
    public ResultMessage findByUserId(@PathVariable String userId, PageParam pageParam) {
        return new ResultMessage<>(messageService.findNotReadByUserId(userId, pageParam));
    }

}
