package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.CourierEvaluate;
import cn.huaruan.ud24.query.entity.TimelyGains;
import cn.huaruan.ud24.service.CourierEvaluateService;

import cn.huaruan.ud24.vo.FindEvaluateAboutCourierParam;
import cn.huaruan.ud24.vo.IncomeInfo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courierEvaluates")
@AllArgsConstructor
@Api(tags = "快递员评价接口")
public class CourierEvaluateController {

    private final CourierEvaluateService evaluateService;

    @DeleteMapping("/{id}")
    @ApiOperation("删除一条评论")
    public ResultMessage deleteEvaluate(@PathVariable("id") Integer id){
        return new ResultMessage(evaluateService.deleteEvaluate(id));
    }

    @PostMapping
    @ApiOperation("添加一条评论")
    public ResultMessage addEvaluate(@RequestBody CourierEvaluate evaluate){
        return new ResultMessage(evaluateService.addCourierEvaluate(evaluate));
    }

    @PostMapping("/addEvaluates")
    @ApiOperation("添加一条评论")
    public ResultMessage addEvaluates(@RequestBody CourierEvaluate evaluate){
        return new ResultMessage(evaluateService.addCourierEvaluate(evaluate));
    }

    @PostMapping("/courierId")
    @ApiOperation("根据快递员Id查询")
    public ResultMessage<Page<CourierEvaluate>> findCourierEvaluateByCourierId(@RequestBody FindEvaluateAboutCourierParam courierParam){
        return new ResultMessage<>(evaluateService.findCourierEvaluateByCourierId(courierParam));
    }

    @PostMapping("/courierIds")
    @ApiOperation("根据快递员Id查询")
    public ResultMessage<PageInfo<IncomeInfo>> findCourierEvaluateByCourierIds(@RequestBody FindEvaluateAboutCourierParam courierParam){
        return new ResultMessage<PageInfo<IncomeInfo>>(evaluateService.findCourierEvaluateByCourierIds(courierParam));
    }

    @PutMapping
    @ApiOperation("修改评价")
    public ResultMessage update(@RequestBody CourierEvaluate courierEvaluate){
        return new ResultMessage(evaluateService.update(courierEvaluate));
    }

    @GetMapping("/updateRules")
    @ApiOperation("修改收益规则")
    public ResultMessage updateRules(@RequestBody TimelyGains timelyGains){
        evaluateService.updateRules(timelyGains);
        return new ResultMessage();
    }

    @PostMapping("/addRules")
    @ApiOperation("修改收益规则")
    public ResultMessage addRules(@RequestBody TimelyGains timelyGains){
        evaluateService.addRules(timelyGains);
        return new ResultMessage();
    }
}
