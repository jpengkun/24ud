package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.ExpectTime;
import cn.huaruan.ud24.query.entity.ExpectTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-01 14:19:52
*/
@Mapper
public interface ExpectTimeMapper {
    long countByExample(ExpectTimeExample example);

    int deleteByExample(ExpectTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExpectTime record);

    int insertSelective(ExpectTime record);

    List<ExpectTime> selectByExample(ExpectTimeExample example);

    ExpectTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExpectTime record, @Param("example") ExpectTimeExample example);

    int updateByExample(@Param("record") ExpectTime record, @Param("example") ExpectTimeExample example);

    int updateByPrimaryKeySelective(ExpectTime record);

    int updateByPrimaryKey(ExpectTime record);
}