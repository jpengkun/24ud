package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.query.entity.TimelyWbLog;
import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.query.mapper.TimelyCourierMapper;
import cn.huaruan.ud24.vo.FindTimelyCourierParam;
import cn.huaruan.ud24.vo.UpdateCourierStateVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelyCourierDao extends TimelyCourierMapper {

    long countTimely(FindTimelyCourierParam arriveParam);

    List<TimelyCourier> findWithSubTimelyArrive(FindTimelyCourierParam arriveParam);

    long updateCourierStateByIds(UpdateCourierStateVo updateCourierStateVo);

    List<String> queryByCourierId(@Param("userId") String userId, @Param("type") Integer type);

    TimelyCourier selectByPhone(String phone);

    List<String> queryRidersByShopName(String shopName);

    @Select(value = "SELECT * from timely_courier tc where tc.small_shop_name = #{shopName}")
    List<TimelyCourier> queryConformRiders(String shopName);

    @Select(value = "select count(*) from timely_wb_log where courier_id = #{id} and state = 4")
    Integer queryCapCount(String id);
}
