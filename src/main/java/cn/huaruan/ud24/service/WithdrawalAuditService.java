package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.BillDao;
import cn.huaruan.ud24.query.dao.WithdrawalAuditDao;
import cn.huaruan.ud24.query.entity.Bill;
import cn.huaruan.ud24.query.entity.WithdrawalAudit;
import cn.huaruan.ud24.query.entity.WithdrawalAuditExample;
import cn.huaruan.ud24.vo.FindWithdrawalAuditParam;
import cn.huaruan.ud24.vo.UpdateAuditStatusVo;
import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class WithdrawalAuditService {

    private final WithdrawalAuditDao auditDao;

    private final BillDao billDao;

    private final CourierService courierService;

    /**
     * 查找
     * @param auditParam
     * @return
     */
    public Page<WithdrawalAudit> find(FindWithdrawalAuditParam auditParam){
        long total = auditDao.countAudit(auditParam);
        List<WithdrawalAudit> audits = auditDao.findAudit(auditParam);
        return new Page<>(total,audits);
    }

    /**
     * 批量处理
     * @param auditStatusVo
     * @return
     */
    public long updateStatus(UpdateAuditStatusVo auditStatusVo){
        AppAsserts.notEmpty(auditStatusVo.getCourierIds(),"快递员id不能为空");
        AppAsserts.notNull(auditStatusVo.getStatus(),"处理状态不能为空");
        WithdrawalAuditExample auditExample = new WithdrawalAuditExample();
        auditExample.createCriteria().andCourierIdIn(auditStatusVo.getCourierIds());
        List<WithdrawalAudit> audits = auditDao.selectByExample(auditExample);
        Date date = new DateTime();
        for (WithdrawalAudit audit : audits) {
            Bill bill = new Bill();
            bill.setStatus(1);
            bill.setCreateTime(date);
            bill.setCourierId(audit.getCourierId());
            bill.setMoney(audit.getMoney());
            bill.setCardNum(audit.getCardNum());
            bill.setType(0);
            billDao.insert(bill);
        }
        return auditDao.updateStatus(auditStatusVo);
    }

    /**
     * 驳回
     * @param withdrawalAudit
     */
    public void reject(WithdrawalAudit withdrawalAudit){
       courierService.reject(withdrawalAudit);
        Bill bill = new Bill();
        bill.setStatus(3);
        bill.setCreateTime(new DateTime());
        bill.setCourierId(withdrawalAudit.getCourierId());
        bill.setMoney(withdrawalAudit.getMoney());
        bill.setCardNum(withdrawalAudit.getCardNum());
        bill.setType(0);
        billDao.insert(bill);
        withdrawalAudit.setStatus(1);
        auditDao.updateByPrimaryKey(withdrawalAudit);
    }

}
