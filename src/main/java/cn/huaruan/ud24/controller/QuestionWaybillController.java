package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.QuestionWaybill;
import cn.huaruan.ud24.service.QuestionWaybillService;
import cn.huaruan.ud24.vo.FindQuestionWaybillParam;
import cn.huaruan.ud24.vo.QuestionWithType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/question/Waybill")
@Api(tags = "问题件")
public class QuestionWaybillController {

    private final QuestionWaybillService service;

    @ApiOperation("添加问题件")
    @PostMapping
    public ResultMessage<QuestionWaybill> addQuestion(@RequestBody QuestionWaybill questionWaybill){
        return new ResultMessage(service.addQuestion(questionWaybill));
    }

    @ApiOperation("删除问题件")
    @DeleteMapping
    public ResultMessage deleteQuestion(@RequestBody List<Integer> ids){
        return new ResultMessage(service.deleteQuestion(ids));
    }

    @ApiOperation("修改问题件")
    @PutMapping
    public ResultMessage updateQuestion(@RequestBody QuestionWaybill questionWaybill){
        return new ResultMessage(service.updateQuestion(questionWaybill));
    }

    @ApiOperation("查找一个")
    @GetMapping("/{id}")
    public ResultMessage<QuestionWaybill> findOne(@PathVariable("id")Integer id){
        return new ResultMessage(service.findOne(id));
    }

    @ApiOperation("条件查询")
    @GetMapping
    public ResultMessage<Page<QuestionWithType>> findWithQuestion(FindQuestionWaybillParam findQuestionWaybillParam){
        return new ResultMessage(service.finQuestion(findQuestionWaybillParam));
    }
}
