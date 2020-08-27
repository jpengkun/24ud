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
@RequestMapping("/vip/waybill")
@AllArgsConstructor
@Api(tags = "VIP运单接口")
public class VipWaybillController {

    private final TodaysWaybillService todaysWaybillService;

    @ApiOperation("预下单")
    @PostMapping
    public ResultMessage<TodaysWbWithLogs> preOrder(@RequestBody TodaysWaybillVo waybill) {
        return new ResultMessage<TodaysWbWithLogs>().data(todaysWaybillService.vipPreOrder(waybill));
    }

    @ApiOperation("批量导入预下单")
    @PostMapping("/import")
    public ResultMessage<ImportResult> importPreOrder(@RequestBody List<TodaysWaybillVo> waybillList) {
        ImportResult importResult = todaysWaybillService.importPreOrder4Vip(waybillList);
        return new ResultMessage<>(importResult);
    }

    @ApiOperation("批量发单")
    @PutMapping("/batch/send")
    public ResultMessage sendOrder(@RequestBody List<String> ids) {
        todaysWaybillService.vipSendOrder(ids);
        return new ResultMessage();
    }

    @ApiOperation("条件查询")
    @GetMapping
    public ResultMessage sendOrder(FindWaybill4VipParam findWaybill4VipParam) {
        return new ResultMessage<>(todaysWaybillService.find4Vip(findWaybill4VipParam));
    }

    @ApiOperation("批量删除预下单")
    @DeleteMapping("/batch/delete")
    public ResultMessage deletePreOrder(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        todaysWaybillService.deleteByIdIn(idList);
        return new ResultMessage<>();
    }

}
