package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.dao.VipBillDao;
import cn.huaruan.ud24.query.dao.VipWayBillDao;
import cn.huaruan.ud24.query.entity.VipWaybill;
import cn.huaruan.ud24.vo.FindVipBillParam;
import cn.huaruan.ud24.vo.VipBillWithWaybill;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class VipBillService {

    private final VipBillDao vipBillDao;

    private final VipWayBillDao wayBillDao;

    /**
     * 添加
     * @param vipBill
     */
    public void addBill(VipBillWithWaybill vipBill){
        AppAsserts.notNull(vipBill,"流水不能为空");
        AppAsserts.notNull(vipBill.getUserId(),"所属用户不能为空");
        AppAsserts.notNull(vipBill.getAmount(),"金额不能为空");
        AppAsserts.notNull(vipBill.getPaymentState(),"支付状态不能为空");
        AppAsserts.notNull(vipBill.getCount(),"数量不能为空");
        vipBill.setCreateTime(new Date());
        vipBill.setId(UUIDUtil.get());
        vipBillDao.insertSelective(vipBill);
        List<String> waybills = vipBill.getWaybills();
        if (waybills!=null&&waybills.size()>0){
            for (String waybill : waybills) {
                VipWaybill vipWaybill = new VipWaybill();
                vipWaybill.setUserId(vipBill.getUserId());
                vipWaybill.setOrderId(waybill);
                vipWaybill.setCreateTime(new Date());
                vipWaybill.setBillId(vipBill.getId());
                wayBillDao.insert(vipWaybill);
            }
        }
    }

    /**
     * 条件查询
     * @param findVipBillParam
     * @return
     */
    public Page<VipBillWithWaybill> findVipBill(FindVipBillParam findVipBillParam){
        long total = vipBillDao.countVipBill(findVipBillParam);
        List<VipBillWithWaybill> list = vipBillDao.findBillWithWaybill(findVipBillParam);
        return new Page<>(total,list);
    }
}
