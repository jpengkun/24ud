package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.service.TodaysWaybillService;
import cn.huaruan.ud24.vo.FindWaybill4VipParam;
import cn.huaruan.ud24.vo.ImportResult;
import cn.huaruan.ud24.vo.TodaysWaybillVo;
import cn.huaruan.ud24.vo.TodaysWbWithLogs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/woho/waybill")
@AllArgsConstructor
@Api(tags = "WOHO运单接口")
public class WohoWaybillController {

    private final TodaysWaybillService waybillService;

    @PostMapping
    @ApiOperation("新增")
    public ResultMessage<TodaysWbWithLogs> add(@RequestBody TodaysWaybillVo todaysWaybillVo) {
        return new ResultMessage<TodaysWbWithLogs>().data(waybillService.insertWithLog4Woho(todaysWaybillVo));
    }
}
