package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.query.mapper.FinanceTimelyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceTimelyDao extends FinanceTimelyMapper {

    long updateFinanceTimely(FinanceTimely financeTimely);
    FinanceTimely findByOId(@Param("oid") String oid);
    FinanceTimely findCalFinanceTimely(@Param("orgId") String orgId);
}
