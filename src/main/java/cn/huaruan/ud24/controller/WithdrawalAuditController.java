package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.WithdrawalAudit;
import cn.huaruan.ud24.service.WithdrawalAuditService;
import cn.huaruan.ud24.vo.FindWithdrawalAuditParam;
import cn.huaruan.ud24.vo.UpdateAuditStatusVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/withdrawal/audit")
@RestController
@AllArgsConstructor
@Api(tags = "提现申请")
public class WithdrawalAuditController {

    private final WithdrawalAuditService auditService;

    @GetMapping
    @ApiOperation("查找")
    public ResultMessage<Page<WithdrawalAudit>> findAudits(FindWithdrawalAuditParam auditParam){
        return new ResultMessage<>(auditService.find(auditParam));
    }

    @PutMapping
    @ApiOperation("批量修改")
    public ResultMessage updateAudit(@RequestBody UpdateAuditStatusVo statusVo){
        auditService.updateStatus(statusVo);
        return new ResultMessage();
    }

    @PutMapping("/reject")
    @ApiOperation("驳回申请")
    public ResultMessage reject(@RequestBody WithdrawalAudit withdrawalAudit){
        auditService.reject(withdrawalAudit);
        return new ResultMessage();
    }
}
