package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.BillDao;
import cn.huaruan.ud24.query.entity.Bill;
import cn.huaruan.ud24.vo.FindBillParam;
import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class BillService {

    private final BillDao billDao;

    private final CourierService courierService;

    /**
     * 添加一笔流水
     * @param bill
     */
    public void addBill(Bill bill){
        AppAsserts.notNull(bill,"流水不能为空");
        AppAsserts.notNull(bill.getCourierId(),"快递员id不能为空");
        AppAsserts.notNull(bill.getMoney(),"金额不能为空");
        AppAsserts.notNull(bill.getType(),"类型不能为空");
        AppAsserts.notNull(bill.getGenre(),"快递员类型不能为空");
        bill.setCreateTime(new DateTime());
        if (bill.getType()==0){//当流水为支出时
            AppAsserts.notNull(bill.getPhone(),"银行预留手机号不能为空");
            AppAsserts.notNull(bill.getBankName(),"银行名字不能为空");
            AppAsserts.notNull(bill.getBankAddress(),"银行地址不能为空");
            AppAsserts.notNull(bill.getCardNum(),"银行卡号不能为空");
            courierService.expend(bill);
            bill.setStatus(0);
        }else{//同步增加
            courierService.income(bill);
            bill.setStatus(1);
        }
        billDao.insert(bill);
    }

    /**
     * 查找
     * @param findBillParam
     * @return
     */
    public Page<Bill> findBillWithPage(FindBillParam findBillParam){
        long total = billDao.countBill(findBillParam);
        List<Bill> bills = billDao.findBill(findBillParam);
        return new Page<>(total,bills);
    }

    /**
     * 押金提现
     * @param bill
     */
    public void deposit(Bill bill){
        AppAsserts.notNull(bill,"流水不能为空");
        AppAsserts.notNull(bill.getCourierId(),"快递员id不能为空");
        AppAsserts.notNull(bill.getMoney(),"金额不能为空");
        AppAsserts.notNull(bill.getType(),"类型不能为空");
        AppAsserts.notNull(bill.getGenre(),"快递员类型不能为空");
        AppAsserts.notNull(bill.getPhone(),"银行预留手机号不能为空");
        AppAsserts.notNull(bill.getBankName(),"银行名字不能为空");
        AppAsserts.notNull(bill.getBankAddress(),"银行地址不能为空");
        AppAsserts.notNull(bill.getCardNum(),"银行卡号不能为空");
        courierService.deposit(bill);
    }


}
