package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TimelyWbLog;
import cn.huaruan.ud24.query.entity.TimelyWbLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-03 14:12:55
*/
@Mapper
public interface TimelyWbLogMapper {
    long countByExample(TimelyWbLogExample example);

    int deleteByExample(TimelyWbLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(TimelyWbLog record);

    int insertSelective(TimelyWbLog record);

    List<TimelyWbLog> selectByExampleWithBLOBs(TimelyWbLogExample example);

    List<TimelyWbLog> selectByExample(TimelyWbLogExample example);

    TimelyWbLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TimelyWbLog record, @Param("example") TimelyWbLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TimelyWbLog record, @Param("example") TimelyWbLogExample example);

    int updateByExample(@Param("record") TimelyWbLog record, @Param("example") TimelyWbLogExample example);

    int updateByPrimaryKeySelective(TimelyWbLog record);

    int updateByPrimaryKeyWithBLOBs(TimelyWbLog record);

    int updateByPrimaryKey(TimelyWbLog record);

    int updateTimelyWbLogAndState(@Param("timelyWbLogState") Integer timelyWbLogState,@Param("waybillId") String waybillId);
}