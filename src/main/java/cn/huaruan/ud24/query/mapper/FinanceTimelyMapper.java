package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.FinanceTimely;
import cn.huaruan.ud24.query.entity.FinanceTimelyExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-03 19:19:45
*/
@Mapper
public interface FinanceTimelyMapper {
    long countByExample(FinanceTimelyExample example);

    int deleteByExample(FinanceTimelyExample example);

    int deleteByPrimaryKey(String timelyId);

    int insert(FinanceTimely record);

    int insertSelective(FinanceTimely record);

    List<FinanceTimely> selectByExample(FinanceTimelyExample example);

    FinanceTimely selectByPrimaryKey(String timelyId);

    int updateByExampleSelective(@Param("record") FinanceTimely record, @Param("example") FinanceTimelyExample example);

    int updateByExample(@Param("record") FinanceTimely record, @Param("example") FinanceTimelyExample example);

    int updateByPrimaryKeySelective(FinanceTimely record);

    int updateByPrimaryKey(FinanceTimely record);
}