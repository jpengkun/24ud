package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Bill;
import cn.huaruan.ud24.service.BillService;
import cn.huaruan.ud24.vo.FindBillParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/bill")
@Api(tags = "流水")
public class BillController {

    private final BillService service;

    /**
     * 添加一条流水
     * @param bill
     * @return
     */
    @PostMapping
    @ApiOperation("添加一条流水")
    public ResultMessage addService(@RequestBody Bill bill){
        service.addBill(bill);
        return new ResultMessage();
    }
    @GetMapping
    @ApiOperation("查找")
    public ResultMessage<Page<Bill>> findBill(FindBillParam billParam){
        return new ResultMessage<>(service.findBillWithPage(billParam));
    }

    @PostMapping("/deposit")
    @ApiOperation("押金提现")
    public ResultMessage deposit(@RequestBody Bill bill){
        service.deposit(bill);
        return new ResultMessage();
    }
}
