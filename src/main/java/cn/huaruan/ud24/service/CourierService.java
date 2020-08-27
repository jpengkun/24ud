package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.exception.ParamException;
import cn.huaruan.ud24.query.dao.TimelyCourierDao;
import cn.huaruan.ud24.query.dao.TodaysCourierDao;
import cn.huaruan.ud24.query.dao.WithdrawalAuditDao;
import cn.huaruan.ud24.query.entity.Bill;
import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.query.entity.WithdrawalAudit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class CourierService {

    private TimelyCourierDao timelyCourierDao;

    private TodaysCourierDao todaysCourierDao;

    private WithdrawalAuditDao auditDao;

    /**
     * 流水支出
     * 通过流水对快递员的余额操作
     *
     * @param bill
     */
    public void expend(Bill bill) {
        if (bill.getGenre() == 0) {
            TodaysCourier todaysCourier = todaysCourierDao.selectByPrimaryKey(bill.getCourierId());
            if (todaysCourier.getMoney().compareTo(bill.getMoney()) == -1) {
                throw new ParamException("余额不足");
            } else {
                todaysCourier.setMoney(todaysCourier.getMoney().subtract(bill.getMoney()));
                todaysCourierDao.updateByPrimaryKey(todaysCourier);
                addAudit(bill, todaysCourier.getName());
            }
        } else {
            TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(bill.getCourierId());
            if (timelyCourier.getMoney().compareTo(bill.getMoney()) == -1) {
                throw new ParamException("余额不足");
            } else {
                timelyCourier.setMoney(timelyCourier.getMoney().subtract(bill.getMoney()));
                timelyCourierDao.updateByPrimaryKey(timelyCourier);
                addAudit(bill, timelyCourier.getName());
            }
        }
    }

    /**
     * 流水收入
     * 通过流水收入的对快递员的余额进行添加
     *
     * @param bill
     */
    public void income(Bill bill) {
        if (bill.getGenre() == 0) {
            TodaysCourier todaysCourier = todaysCourierDao.selectByPrimaryKey(bill.getCourierId());
            todaysCourier.setMoney(todaysCourier.getMoney().add(bill.getMoney()));
            todaysCourierDao.updateByPrimaryKey(todaysCourier);
        } else {
            TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(bill.getCourierId());
            timelyCourier.setMoney(timelyCourier.getMoney().add(bill.getMoney()));
            timelyCourierDao.updateByPrimaryKey(timelyCourier);
        }
    }

    /**
     * 押金提现
     *
     * @param bill
     */
    public void deposit(Bill bill) {
        TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(bill.getCourierId());
        if (timelyCourier.getDeposit().compareTo(bill.getMoney()) == -1) {
            throw new ParamException("当前快递员未交押金");
        } else {
            timelyCourier.setDeposit(new BigDecimal(0));
            timelyCourierDao.updateByPrimaryKey(timelyCourier);
            addAudit(bill, timelyCourier.getName());
        }

    }


    /**
     * 添加流水的时候发送一条待提现的请求
     *
     * @param bill
     * @param name
     */
    public void addAudit(Bill bill, String name) {
        WithdrawalAudit withdrawalAudit = new WithdrawalAudit();
        withdrawalAudit.setApplyTime(bill.getCreateTime());
        withdrawalAudit.setCardNum(bill.getCardNum());
        withdrawalAudit.setCourierId(bill.getCourierId());
        withdrawalAudit.setMoney(bill.getMoney());
        withdrawalAudit.setCourierName(name);
        withdrawalAudit.setStatus(0);
        withdrawalAudit.setGenre(bill.getGenre());
        withdrawalAudit.setPhone(bill.getPhone());
        withdrawalAudit.setBankName(bill.getBankName());
        withdrawalAudit.setBankAddress(bill.getBankAddress());
        auditDao.insert(withdrawalAudit);
    }

    public void reject(WithdrawalAudit withdrawalAudit) {
        if (withdrawalAudit.getGenre() == 0) {
            TodaysCourier todaysCourier = todaysCourierDao.selectByPrimaryKey(withdrawalAudit.getCourierId());
            todaysCourier.setMoney(todaysCourier.getMoney().add(withdrawalAudit.getMoney()));
            todaysCourierDao.updateByPrimaryKey(todaysCourier);
        } else {
            TimelyCourier timelyCourier = timelyCourierDao.selectByPrimaryKey(withdrawalAudit.getCourierId());
            timelyCourier.setMoney(timelyCourier.getMoney().add(withdrawalAudit.getMoney()));
            timelyCourierDao.updateByPrimaryKey(timelyCourier);
        }
    }
}
