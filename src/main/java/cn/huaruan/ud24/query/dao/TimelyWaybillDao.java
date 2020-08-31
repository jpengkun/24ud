package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.TimelyUtil;
import cn.huaruan.ud24.query.entity.TimelyWaybill;
import cn.huaruan.ud24.query.mapper.TimelyWaybillMapper;
import cn.huaruan.ud24.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface TimelyWaybillDao extends TimelyWaybillMapper {
    long insertWithLocation(TimelyWaybillVo timelyWaybill);

    long updateWithLocationById(TimelyWaybillVo timelyWaybill);

    long countTimelyWaybill(FindWaybillParam findWaybillParam);

    List<TimelyWbWithLogs> findTimelyWaybillWithLogs(FindWaybillParam findWaybillParam);

    long countByCircleVo(CircleVo circleVo);

    List<TimelyWbWithLogs> findByCircleVo(CircleVo circleVo);

    long countByCourierIdAndState(FindWbByCidAndState findWbByCidAndState);

    List<TimelyWbWithLogs> findByCourierIdAndState(FindWbByCidAndState findWbByCidAndState);

    TimelyWbWithLogs findById(String id);

    TimelyWbWithLogs findByNo(String no);

    long countByOpenId(FindWbByOpenId findWbByOpenId);

    List<TimelyWbWithLogs> findByOpenId(FindWbByOpenId findWbByOpenId);

    long updateStateById(@Param("id") String id, @Param("state") Integer state, @Param("date") Date date);

    long payById(String id);

    void signFor(@Param("uuid") String uuid, @Param("wbId") String wbId, @Param("userId") String userId);


    long countTimelyWaybills(@Param("riderId") String riderId, @Param("month") String month, @Param("years") String years);

    List<TimelyWaybill> getOrderHistoryRiderId(@Param("riderId") String riderId, @Param("years") String years, @Param("month") String month);
}
