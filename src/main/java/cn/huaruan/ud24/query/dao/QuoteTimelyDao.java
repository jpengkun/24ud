package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.QuoteTimely;
import cn.huaruan.ud24.query.mapper.QuoteTimelyMapper;
import cn.huaruan.ud24.vo.FindQuoteParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteTimelyDao extends QuoteTimelyMapper {

    QuoteTimely findQuoteTimely(@Param("oid") String oId);

    QuoteTimely findIsTruePolygon(FindQuoteParam findQuoteParam);

    QuoteTimely findCalQuoteTimely(@Param("orgId") String orgId);

}
