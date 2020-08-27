package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.service.VipBillService;
import cn.huaruan.ud24.vo.FindVipBillParam;
import cn.huaruan.ud24.vo.VipBillWithWaybill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/vip/bill")
@Api(tags = "流水")
public class VipBillController {

    private final VipBillService service;

    /**
     * 添加一条流水
     * @param bill
     * @return
     */
    @PostMapping
    @ApiOperation("添加一条流水")
    public ResultMessage addService(@RequestBody VipBillWithWaybill bill){
        service.addBill(bill);
        return new ResultMessage();
    }
    @GetMapping
    @ApiOperation("查找")
    public ResultMessage<Page<VipBillWithWaybill>> findBill(FindVipBillParam billParam){
        return new ResultMessage<>(service.findVipBill(billParam));
    }

}
