package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.FinanceToday;
import cn.huaruan.ud24.query.entity.FinanceTodayExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-03 19:19:56
*/
@Mapper
public interface FinanceTodayMapper {
    long countByExample(FinanceTodayExample example);

    int deleteByExample(FinanceTodayExample example);

    int deleteByPrimaryKey(String todayId);

    int insert(FinanceToday record);

    int insertSelective(FinanceToday record);

    List<FinanceToday> selectByExample(FinanceTodayExample example);

    FinanceToday selectByPrimaryKey(String todayId);

    int updateByExampleSelective(@Param("record") FinanceToday record, @Param("example") FinanceTodayExample example);

    int updateByExample(@Param("record") FinanceToday record, @Param("example") FinanceTodayExample example);

    int updateByPrimaryKeySelective(FinanceToday record);

    int updateByPrimaryKey(FinanceToday record);
}