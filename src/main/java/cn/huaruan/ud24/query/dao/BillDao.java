package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Bill;
import cn.huaruan.ud24.query.mapper.BillMapper;
import cn.huaruan.ud24.vo.FindBillParam;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface BillDao extends BillMapper {

    long countBill(FindBillParam billParam);

    List<Bill> findBill(FindBillParam findBillParam);

    BigDecimal countIncome(String courierId, Date starTime, Date endTime);
}
