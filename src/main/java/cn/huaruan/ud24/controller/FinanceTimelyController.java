package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.service.FinanceTimelyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financeTimely")
@AllArgsConstructor
@Api(tags = "加盟商即时达分成规则")
public class FinanceTimelyController {

    private final FinanceTimelyService financeTimelyService;
    
    
    @ApiOperation("添加加盟商即时达分成规则")
    @PostMapping
    public ResultMessage<Object> addFinanceTimely(@RequestBody FinanceTimely financeTimely){
        financeTimelyService.addFinanceTimely(financeTimely);
        return new ResultMessage<>();
    }


    @ApiOperation("修改加盟商分成规则")
    @PutMapping
    public ResultMessage<Object> update(@RequestBody FinanceTimely financeTimely){
        financeTimelyService.updateFinanceTimely(financeTimely);
        return new ResultMessage<>();
    }


    @ApiOperation("根据oid查询加盟商即时达分成规则")
    @GetMapping("/findByOid")
    public ResultMessage<FinanceTimely> findByOId(String oid){
        return new ResultMessage<>(financeTimelyService.findByOId(oid));
    }

}
