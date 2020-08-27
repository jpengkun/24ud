package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.QuoteToday;
import cn.huaruan.ud24.query.mapper.QuoteTodayMapper;
import cn.huaruan.ud24.vo.FindQuoteParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteTodayDao extends QuoteTodayMapper {

    List<QuoteToday> findQuoteToday(QuoteToday quoteToday);

    QuoteToday findByOId(@Param("oid") String oid);
    long countQuote(FindQuoteParam findComplaintParam);

    QuoteToday findCalQuoteToday(@Param("orgId") String orgId);

}
