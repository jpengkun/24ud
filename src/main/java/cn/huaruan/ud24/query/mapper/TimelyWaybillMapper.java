package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.query.entity.TimelyWaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-09 00:15:59
*/
@Mapper
public interface TimelyWaybillMapper {
    long countByExample(TimelyWaybillExample example);

    int deleteByExample(TimelyWaybillExample example);

    int deleteByPrimaryKey(String id);

    int insert(TimelyWaybill record);

    int insertSelective(TimelyWaybill record);

    List<TimelyWaybill> selectByExample(TimelyWaybillExample example);

    TimelyWaybill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TimelyWaybill record, @Param("example") TimelyWaybillExample example);

    int updateByExample(@Param("record") TimelyWaybill record, @Param("example") TimelyWaybillExample example);

    int updateByPrimaryKeySelective(TimelyWaybill record);

    int updateByPrimaryKey(TimelyWaybill record);
}