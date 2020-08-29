package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.query.entity.TimelyCourierExample;
import java.util.List;

import cn.huaruan.ud24.query.entity.TimelyWaybill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-07 15:48:16
*/
@Mapper
public interface TimelyCourierMapper {
    long countByExample(TimelyCourierExample example);

    int deleteByExample(TimelyCourierExample example);

    int deleteByPrimaryKey(String id);

    int insert(TimelyCourier record);

    int insertSelective(TimelyCourier record);

    List<TimelyCourier> selectByExample(TimelyCourierExample example);

    TimelyCourier selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TimelyCourier record, @Param("example") TimelyCourierExample example);

    int updateByExample(@Param("record") TimelyCourier record, @Param("example") TimelyCourierExample example);

    int updateByPrimaryKeySelective(TimelyCourier record);

    int updateByPrimaryKey(TimelyCourier record);

}