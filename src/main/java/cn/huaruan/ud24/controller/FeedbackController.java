package cn.huaruan.ud24.controller;



import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.PageParam;
import cn.huaruan.ud24.query.entity.Feedback;
import cn.huaruan.ud24.service.FeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/feedBacks")
@AllArgsConstructor
@Api(tags = "意见反馈")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    @ApiOperation("添加反馈并返回反馈id")
    public ResultMessage<?> addFeedBack(@RequestBody Feedback feedBack){
        feedbackService.addFeedBack(feedBack);
        return new ResultMessage();
    }

    @GetMapping
    @ApiOperation("查找所有的反馈并分页")
    public ResultMessage<Page> getFeedBacks(@RequestBody PageParam pageParam){
        return new ResultMessage<>(feedbackService.getAllFeedBackByPage(pageParam));
    }
}
