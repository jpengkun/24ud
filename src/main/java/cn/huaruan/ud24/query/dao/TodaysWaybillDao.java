package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.TodaysWaybillMapper;
import cn.huaruan.ud24.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author outas
 */
@Repository
public interface TodaysWaybillDao extends TodaysWaybillMapper {
    long insertWithLocation(TodaysWaybillVo todaysWaybill);

    long updateWithLocationById(TodaysWaybillVo todaysWaybill);

    long countTodaysWaybill(FindWaybillParam findWaybillParam);

    List<TodaysWbWithLogs> findTodaysWaybillWithLogs(FindWaybillParam findWaybillParam);

    long countByCourierIdAndState(FindWbByCidAndState findWbByCidAndState);

    List<TodaysWbWithLogs> findByCourierIdAndState(FindWbByCidAndState findWbByCidAndState);

    TodaysWbWithLogs findById(String id);

    List<TodaysWbWithLogs> findByIdIn(List<String> ids);

    TodaysWbWithLogs findByNo(String no);

    long countByOpenId(FindWbByOpenId findWbByOpenId);

    List<TodaysWbWithLogs> findByOpenId(FindWbByOpenId findWbByOpenId);

    long updateStateById(@Param("id") String id,@Param("state") Integer state,@Param("date") Date date);

    long payById(String id);

    long countWaybill4Vip(FindWaybill4VipParam findWaybill4VipParam);

    List<TodaysWbWithLogs> findWaybill4Vip(FindWaybill4VipParam findWaybill4VipParam);

    List<String> find4Stmt(@Param("state") Integer state,
                           @Param("courierId") String courierId,
                           @Param("timeStart") Date timeStart,
                           @Param("timeEnd") Date timeEnd);
}
