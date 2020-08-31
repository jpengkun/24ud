package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.PdfUtils;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.service.TodaysWaybillService;
import cn.huaruan.ud24.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author outas
 */
@RestController
@RequestMapping("/todays/waybill")
@AllArgsConstructor
@Api(tags = "当日达运单")
@CrossOrigin
public class TodaysWaybillController {

    private final TodaysWaybillService waybillService;

    @GetMapping
    @ApiOperation("条件分页查询")
    public ResultMessage<Page<TodaysWbWithLogs>> findAll(FindWaybillParam findWaybillParam) {
        Page<TodaysWbWithLogs> wbWithLogsPage = waybillService.getAllByParamPaged(findWaybillParam);
        return new ResultMessage<>(wbWithLogsPage);
    }

    @GetMapping("/id/{id}")
    @ApiOperation("根据id查询")
    public ResultMessage<TodaysWbWithLogs> findById(@PathVariable String id) {
        return new ResultMessage<>(waybillService.findById(id));
    }

    @GetMapping("/no/{no}")
    @ApiOperation("根据运单号查询")
    public ResultMessage<TodaysWbWithLogs> findByNo(@PathVariable String no) {
        return new ResultMessage<>(waybillService.findByNo(no));
    }

    @GetMapping("/custom")
    @ApiOperation("根据下单人openId分页查询所有运单记录")
    public ResultMessage<Page<TodaysWbWithLogs>> findByOpenId(FindWbByOpenId findWbByOpenId) {
        return new ResultMessage<>(waybillService.findByOpenId(findWbByOpenId));
    }

    @GetMapping("/todo")
    @ApiOperation("快递员查询待完成的运单列表")
    public ResultMessage<Page<TodaysWbWithLogs>> findByCidAndState(FindWbByCidAndState findWbByCidAndState) {
        return new ResultMessage<>(waybillService.findByCidAndState(findWbByCidAndState));
    }

    @PutMapping
    @ApiOperation("更新")
    public ResultMessage update(@RequestBody TodaysWaybillVo todaysWaybillVo) {
        waybillService.update(todaysWaybillVo);
        return new ResultMessage<>();
    }

    @PostMapping
    @ApiOperation("新增")
    public ResultMessage<TodaysWbWithLogs> add(@RequestBody TodaysWaybillVo todaysWaybillVo) {
        return new ResultMessage<TodaysWbWithLogs>().data(waybillService.insertWithLog(todaysWaybillVo));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResultMessage delete(@PathVariable String id) {
        waybillService.delete(id);
        return new ResultMessage<>();
    }

    @PutMapping("/scan")
    @ApiOperation("扫描")
    public ResultMessage<String> scan(@RequestBody TodaysWbLogVo log) {
        waybillService.insertLog(log);
        return new ResultMessage<>();
    }

    @PutMapping("/scan/batch")
    @ApiOperation("批量扫描")
    public ResultMessage<String> scan(@RequestBody List<TodaysWbLogVo> logs) {
        logs.forEach(waybillService::insertLog);
        return new ResultMessage<>();
    }

    @GetMapping("/print")
    @ApiOperation("运单生成pdf")
    public ResultMessage<String> print(String ids) {
        List<String> idList = Arrays.asList(ids.split(","));
        return new ResultMessage<>(PdfUtils.printOrder(waybillService.findByIdIn(idList)));
    }

    @PostMapping("/import")
    @ApiOperation("批量导入运单")
    public ResultMessage<String> importWb(@RequestBody List<TodaysWaybillVo> waybillList) {
        waybillService.importWaybill(waybillList);
        return new ResultMessage<>();
    }

}
