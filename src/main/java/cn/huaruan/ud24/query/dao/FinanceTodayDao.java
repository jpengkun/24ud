package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.FinanceToday;
import cn.huaruan.ud24.query.mapper.FinanceTodayMapper;
import cn.huaruan.ud24.vo.FindFinacne;
import cn.huaruan.ud24.vo.OrganizationWithFinanceNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceTodayDao extends FinanceTodayMapper {

    long updateFinanceToday(FinanceToday financeToday);
    FinanceToday findByOId(@Param("oid") String oid);

    List<OrganizationWithFinanceNode> findFinanceByOid(FindFinacne findFinacne);
    FinanceToday findCalFinanceToday(@Param("orgId") String orgId);
}
