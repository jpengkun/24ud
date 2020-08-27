package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TodaysWbLog;
import cn.huaruan.ud24.query.entity.TodaysWbLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-03 14:12:55
*/
@Mapper
public interface TodaysWbLogMapper {
    long countByExample(TodaysWbLogExample example);

    int deleteByExample(TodaysWbLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TodaysWbLog record);

    int insertSelective(TodaysWbLog record);

    List<TodaysWbLog> selectByExampleWithBLOBs(TodaysWbLogExample example);

    List<TodaysWbLog> selectByExample(TodaysWbLogExample example);

    TodaysWbLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TodaysWbLog record, @Param("example") TodaysWbLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TodaysWbLog record, @Param("example") TodaysWbLogExample example);

    int updateByExample(@Param("record") TodaysWbLog record, @Param("example") TodaysWbLogExample example);

    int updateByPrimaryKeySelective(TodaysWbLog record);

    int updateByPrimaryKeyWithBLOBs(TodaysWbLog record);

    int updateByPrimaryKey(TodaysWbLog record);
}