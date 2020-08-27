package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.QuestionType;
import cn.huaruan.ud24.service.QuestionTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/question/type")
@Api(tags = "问题件类型")
public class QuestionTypeController {

    private final QuestionTypeService service;

    @ApiOperation("添加一个问题件类型")
    @PostMapping
    public ResultMessage addType(@RequestBody QuestionType questionType){
        return new ResultMessage(service.addType(questionType));
    }

    @ApiOperation("删除一个问题件类型")
    @DeleteMapping
    public ResultMessage deleteType(@RequestBody List<Integer> ids){
        return new ResultMessage(service.deleteType(ids));
    }

    @PutMapping
    @ApiOperation("修改一个问题件类型")
    public ResultMessage updateType(@RequestBody QuestionType questionType){
        return new ResultMessage(service.updateType(questionType));
    }

    @GetMapping
    @ApiOperation("查找所有类型")
    public ResultMessage<List<QuestionType>> findAll(){
        return new ResultMessage<>(service.findQuestion());
    }

    @GetMapping("/{id}")
    @ApiOperation("查找一个类型")
    public ResultMessage<QuestionType> findOne(@PathVariable("id") Integer id){
        return new ResultMessage<>(service.findOne(id));
    }
}
