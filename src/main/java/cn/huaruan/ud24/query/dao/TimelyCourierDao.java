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

    @Select(value = "SELECT tc.id\n" +
            "        from timely_courier tc,timely_wb_log twl\n" +
            "        where tc.is_open = 1\n" +
            "        and twl.courier_id = tc.id\n" +
            "        and twl.state != 4\n" +
            "        and to_days(twl.create_time) = to_days(now())\n" +
            "        and tc.small_shop_name = #{shopName}")
    List<TimelyCourier> queryConformRiders(String shopName);
}
