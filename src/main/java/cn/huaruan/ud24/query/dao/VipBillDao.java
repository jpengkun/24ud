package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.VipBillMapper;
import cn.huaruan.ud24.vo.FindVipBillParam;
import cn.huaruan.ud24.vo.VipBillWithWaybill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipBillDao extends VipBillMapper {

    long countVipBill(FindVipBillParam vipBillParam);

    List<VipBillWithWaybill> findBillWithWaybill(FindVipBillParam findVipBillParam);
}
