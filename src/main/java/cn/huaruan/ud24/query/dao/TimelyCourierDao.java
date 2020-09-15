package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.RiderInfo;
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

    List<TimelyWbLog> queryByCourierId(@Param("userId") String userId, @Param("type") Integer type);

    TimelyCourier selectByPhone(String phone);

    List<String> queryRidersByShopName(String shopName);

    @Select(value = "SELECT * from timely_courier tc where tc.small_shop_name = #{shopName}")
    List<TimelyCourier> queryConformRiders(String shopName);

    @Select(value = "select count(*) from timely_wb_log where courier_id = #{id} and state = 4")
    Integer queryCapCount(String id);

    @Select(value = "select * from timely_courier where small_shop_id = #{shopId} ")
    List<TimelyCourier> selectByShopId(@Param("shopId") String shopId);


    @Select(value = "select * from timely_waybill where tm_no = #{tmNo} ")
    TimelyWaybill selectByShopIdse(@Param("tmNo") String wbId);

    @Select(value = "select * from timely_wb_log where wb_id = #{wbId}")
    TimelyWbLog findById(@Param("wbId")String wbId);

    @Select(value = "select name from timely_courier where id = #{courierId}")
    String findByIds(@Param("courierId")String courierId);

    /**
     * @param wbNo
     * @return
     */
    @Select(value = "select tc.id, tc.`name`,tc.small_shop_name, twl.closed_time \n" +
            "from timely_waybill tw,timely_wb_log twl,timely_courier tc\n" +
            "where tw.tm_no = #{wbNo} \n" +
            "and tw.id = twl.wb_id\n" +
            "and tc.id = twl.courier_id")
    RiderInfo getRiderName(String wbNo);
}
