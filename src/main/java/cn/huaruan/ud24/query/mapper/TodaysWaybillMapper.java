package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.TodaysWaybill;
import cn.huaruan.ud24.query.entity.TodaysWaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TodaysWaybillMapper {
    long countByExample(TodaysWaybillExample example);

    int deleteByExample(TodaysWaybillExample example);

    int deleteByPrimaryKey(String id);

    int insert(TodaysWaybill record);

    int insertSelective(TodaysWaybill record);

    List<TodaysWaybill> selectByExample(TodaysWaybillExample example);

    TodaysWaybill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TodaysWaybill record, @Param("example") TodaysWaybillExample example);

    int updateByExample(@Param("record") TodaysWaybill record, @Param("example") TodaysWaybillExample example);

    int updateByPrimaryKeySelective(TodaysWaybill record);

    int updateByPrimaryKey(TodaysWaybill record);
}