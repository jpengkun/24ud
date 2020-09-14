package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.CourierEvaluate;
import cn.huaruan.ud24.query.entity.CourierEvaluateExample;
import java.util.List;

import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.query.entity.TimelyGains;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-11-25 15:25:03
*/
@Mapper
public interface CourierEvaluateMapper {
    long countByExample(CourierEvaluateExample example);

    int deleteByExample(CourierEvaluateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourierEvaluate record);

    int insertSelective(CourierEvaluate record);

    List<CourierEvaluate> selectByExample(CourierEvaluateExample example);

    CourierEvaluate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourierEvaluate record, @Param("example") CourierEvaluateExample example);

    int updateByExample(@Param("record") CourierEvaluate record, @Param("example") CourierEvaluateExample example);

    int updateByPrimaryKeySelective(CourierEvaluate record);

    int updateByPrimaryKey(CourierEvaluate record);

    Double findByIdEarnings(@Param("wbId") String wbId);

    String findById(@Param("courierId") String courierId);

    void updateRules(TimelyGains timelyGains);
}