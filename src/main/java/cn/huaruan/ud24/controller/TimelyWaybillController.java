package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.constant.TimelyWaybillState;
import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.vo.*;
import cn.huaruan.ud24.service.TimelyWaybillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

/**
 * @author outas
 */
@RestController
@RequestMapping("/timely/waybill")
@AllArgsConstructor
@Api(tags = "即时达运单")
public class TimelyWaybillController {

    private final TimelyWaybillService waybillService;

    @GetMapping
    @ApiOperation("条件分页查询")
    public ResultMessage<Page<TimelyWaybill>> findCourierWithSubCourier(FindWaybillParam findWaybillParam) {

        Page<TimelyWbWithLogs> wbWithLogsPage = waybillService.getAllByParamPaged(findWaybillParam);
        return new ResultMessage(wbWithLogsPage);
    }

    @GetMapping("/id/{id}")
    @ApiOperation("根据id查询")
    public ResultMessage<TimelyWaybill> findById(@PathVariable String id) {
        return new ResultMessage<>(waybillService.findById(id));
    }



    @GetMapping("/no/{no}")
    @ApiOperation("根据运单号查询")
    public ResultMessage<TimelyWaybill> findByNo(@PathVariable String no) {
        return new ResultMessage<>(waybillService.findByNo(no));
    }

    @GetMapping("/custom")
    @ApiOperation("根据下单人openId分页查询所有运单记录")
    public ResultMessage<Page<TimelyWbWithLogs>> findByOpenId(FindWbByOpenId findWbByOpenId) {
        return new ResultMessage<>(waybillService.findByOpenId(findWbByOpenId));
    }

    @GetMapping("/listening")
    @ApiOperation("听单")
    public ResultMessage<Page<TimelyWbWithLogs>> findByCircle(@ApiParam("经度") Double x,
                                                              @ApiParam("纬度") Double y,
                                                              @ApiParam("半径") Double radius) {
        CircleVo circleVo = new CircleVo(new Point(x, y), radius, TimelyWaybillState.WAITING_ORDER.getState());
        return new ResultMessage<>(waybillService.findWithinRadius(circleVo));
    }

    @GetMapping("/signFor")
    @ApiOperation("签收")
    public ResultMessage signFor(String wbId,String userId){
        waybillService.signFor(wbId,userId);
        return new ResultMessage<>().success();
    }


    @GetMapping("/todo")
    @ApiOperation("快递员查询待完成的运单列表")
    public ResultMessage<Page<TimelyWbWithLogs>> findByCidAndState(FindWbByCidAndState findWbByCidAndState) {
        return new ResultMessage<>(waybillService.findByCidAndState(findWbByCidAndState));
    }

    @PutMapping
    @ApiOperation("更新")
    public ResultMessage update(@RequestBody TimelyWaybillVo timelyWaybillVo) {
        waybillService.update(timelyWaybillVo);
        return new ResultMessage<>();
    }

    @PostMapping
    @ApiOperation("新增")
    public ResultMessage<TimelyWbWithLogs> add(@RequestBody TimelyWaybillVo timelyWaybillVo) {
        return new ResultMessage<TimelyWbWithLogs>().data(waybillService.insert(timelyWaybillVo));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResultMessage delete(@PathVariable String id) {
        waybillService.delete(id);
        return new ResultMessage<>();
    }

    @PutMapping("/scan")
    @ApiOperation("扫描")
    public ResultMessage<String> scan(@RequestBody TimelyWbLogVo log) {
        waybillService.insertLog(log);
        return new ResultMessage<>();
    }

    @GetMapping("/pay/notify/{wbId}")
    public ResultMessage scan(@PathVariable String wbId, @RequestBody Object o) {
        return new ResultMessage<>(o).message(wbId);
    }
}
