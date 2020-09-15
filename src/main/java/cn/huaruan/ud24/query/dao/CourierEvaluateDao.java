package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.CourierEvaluate;
import cn.huaruan.ud24.query.entity.TimelyGains;
import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.query.mapper.CourierEvaluateMapper;
import cn.huaruan.ud24.vo.FindEvaluateAboutCourierParam;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CourierEvaluateDao extends CourierEvaluateMapper {

    long countEvaluate(FindEvaluateAboutCourierParam courierParam);

    List<CourierEvaluate> findCourierEvaluateByCourierId(FindEvaluateAboutCourierParam courierParam);


    Double findAvgEvaluateByCourierId(String userId);

    CourierEvaluate findByWbIdCourierEvaluate(String wbId);

    void addRules(TimelyGains timelyGains);

    TimelyWaybill findByIdWbId(String wbId);
}
