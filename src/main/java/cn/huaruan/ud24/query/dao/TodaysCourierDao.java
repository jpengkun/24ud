package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.TodaysCourier;
import cn.huaruan.ud24.query.mapper.TodaysCourierMapper;
import cn.huaruan.ud24.vo.FindCourierParam;
import cn.huaruan.ud24.vo.TodaysCourierWithOrganization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodaysCourierDao extends TodaysCourierMapper {


    long countCourier(FindCourierParam findCourierParam);

    /**
     *条件查询
     * @param findCourierParam
     * @return
     */
    List<TodaysCourierWithOrganization> findCourierWithSubCourier(FindCourierParam findCourierParam);

    List<TodaysCourierWithOrganization> findAll(FindCourierParam findCourierParam);

}
