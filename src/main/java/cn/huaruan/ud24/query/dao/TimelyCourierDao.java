package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.query.mapper.TimelyCourierMapper;
import cn.huaruan.ud24.vo.FindTimelyCourierParam;
import cn.huaruan.ud24.vo.UpdateCourierStateVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelyCourierDao extends TimelyCourierMapper {

    long countTimely(FindTimelyCourierParam arriveParam);

    List<TimelyCourier> findWithSubTimelyArrive(FindTimelyCourierParam arriveParam);

    long updateCourierStateByIds(UpdateCourierStateVo updateCourierStateVo);

    TimelyCourier selectByPhone(String phone);

}
