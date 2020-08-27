package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.ExpectTime;
import cn.huaruan.ud24.service.ExpectTimeService;
import cn.huaruan.ud24.vo.ExpectTimeWithOrganization;
import cn.huaruan.ud24.vo.FindExpectTimeParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/expect/time")
@Api(tags = "班车时间/期望送达时间")
public class ExpectTimeController {

    private final ExpectTimeService service;

    @ApiOperation("添加班车时间")
    @PostMapping
    public ResultMessage addExpectTime(@RequestBody ExpectTimeWithOrganization time){
        List<ExpectTime> list =time.getTimes();
        for (ExpectTime expectTime : list) {
            expectTime.setOid(time.getOid());
            service.addExpectTime(expectTime);
        }
        return new ResultMessage();
    }

    @DeleteMapping
    @ApiOperation("删除班车时间")
    public ResultMessage deleteExpectTime(@RequestBody List<Integer> ids){
        return new ResultMessage(service.deleteExpect(ids));
    }

    @PutMapping
    @ApiOperation("修改班车时间")
    public ResultMessage updateExpectTime(@RequestBody ExpectTime expectTime){
        return new ResultMessage(service.updateExpect(expectTime));
    }

    @GetMapping
    @ApiOperation("查找班车时间 不传oid默认查全部")
    public ResultMessage<Page<ExpectTime>> findExpectTime(FindExpectTimeParam expectTimeParam){
        return new ResultMessage(service.findExpectTimeByOid(expectTimeParam));
    }
}
