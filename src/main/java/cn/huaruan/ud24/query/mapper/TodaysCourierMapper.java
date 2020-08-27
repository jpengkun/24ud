package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.query.entity.TodaysCourierExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-07 16:21:33
*/
@Mapper
public interface TodaysCourierMapper {
    long countByExample(TodaysCourierExample example);

    int deleteByExample(TodaysCourierExample example);

    int deleteByPrimaryKey(String id);

    int insert(TodaysCourier record);

    int insertSelective(TodaysCourier record);

    List<TodaysCourier> selectByExample(TodaysCourierExample example);

    TodaysCourier selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TodaysCourier record, @Param("example") TodaysCourierExample example);

    int updateByExample(@Param("record") TodaysCourier record, @Param("example") TodaysCourierExample example);

    int updateByPrimaryKeySelective(TodaysCourier record);

    int updateByPrimaryKey(TodaysCourier record);
}