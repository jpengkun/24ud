package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.QuoteToday;
import cn.huaruan.ud24.query.entity.QuoteTodayExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-04 19:04:47
*/
@Mapper
public interface QuoteTodayMapper {
    long countByExample(QuoteTodayExample example);

    int deleteByExample(QuoteTodayExample example);

    int deleteByPrimaryKey(String id);

    int insert(QuoteToday record);

    int insertSelective(QuoteToday record);

    List<QuoteToday> selectByExample(QuoteTodayExample example);

    QuoteToday selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") QuoteToday record, @Param("example") QuoteTodayExample example);

    int updateByExample(@Param("record") QuoteToday record, @Param("example") QuoteTodayExample example);

    int updateByPrimaryKeySelective(QuoteToday record);

    int updateByPrimaryKey(QuoteToday record);
}