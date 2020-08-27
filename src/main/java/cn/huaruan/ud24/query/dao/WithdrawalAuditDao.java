package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.WithdrawalAudit;
import cn.huaruan.ud24.query.entity.WithdrawalAuditExample;
import cn.huaruan.ud24.query.mapper.WithdrawalAuditMapper;
import cn.huaruan.ud24.vo.FindWithdrawalAuditParam;
import cn.huaruan.ud24.vo.UpdateAuditStatusVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawalAuditDao extends WithdrawalAuditMapper {
    long countAudit(FindWithdrawalAuditParam auditParam);

    List<WithdrawalAudit> findAudit(FindWithdrawalAuditParam auditParam);

    long updateStatus(UpdateAuditStatusVo updateAuditStatusVo);
}
