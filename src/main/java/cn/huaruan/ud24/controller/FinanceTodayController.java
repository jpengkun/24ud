package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.FinanceToday;
import cn.huaruan.ud24.service.FinanceTodayService;
import cn.huaruan.ud24.vo.FindFinacne;
import cn.huaruan.ud24.vo.OrganizationWithFinanceNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financeToday")
@AllArgsConstructor
@Api(tags = "加盟商当日达分成规则")
public class FinanceTodayController {

    private final FinanceTodayService financeTodayService;


    @ApiOperation("查询加盟商分成规则")
    @GetMapping
    public ResultMessage<List<OrganizationWithFinanceNode>> findAll(FindFinacne findFinacne){
        return new ResultMessage<>(financeTodayService.findAll(findFinacne));
    }

    @ApiOperation("添加加盟商当日达分成规则")
    @PostMapping
    public ResultMessage<Object> addFinanceToday(@RequestBody FinanceToday financeToday){
        financeTodayService.addFinanceToday(financeToday);
        return new ResultMessage<>();
    }


    @ApiOperation("修改加盟商分成规则")
    @PutMapping
    public ResultMessage<Object> update(@RequestBody FinanceToday financeToday){
        financeTodayService.updateFinanceToday(financeToday);
        return new ResultMessage<>();
    }


    @ApiOperation("根据oid查询加盟商当日达分成规则")
    @GetMapping("/findByOid")
    public ResultMessage<FinanceToday> findByOId(String oid){
        return new ResultMessage<>(financeTodayService.findByOId(oid));
    }


}