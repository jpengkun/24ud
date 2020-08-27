package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.QuoteTimely;
import cn.huaruan.ud24.query.entity.QuoteTimelyExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-04 19:04:09
*/
@Mapper
public interface QuoteTimelyMapper {
    long countByExample(QuoteTimelyExample example);

    int deleteByExample(QuoteTimelyExample example);

    int deleteByPrimaryKey(String id);

    int insert(QuoteTimely record);

    int insertSelective(QuoteTimely record);

    List<QuoteTimely> selectByExample(QuoteTimelyExample example);

    QuoteTimely selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QuoteTimely record, @Param("example") QuoteTimelyExample example);

    int updateByExample(@Param("record") QuoteTimely record, @Param("example") QuoteTimelyExample example);

    int updateByPrimaryKeySelective(QuoteTimely record);

    int updateByPrimaryKey(QuoteTimely record);
}