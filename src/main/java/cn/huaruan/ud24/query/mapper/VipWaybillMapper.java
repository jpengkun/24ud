package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.VipWaybill;
import cn.huaruan.ud24.query.entity.VipWaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-10 15:02:51
*/
@Mapper
public interface VipWaybillMapper {
    long countByExample(VipWaybillExample example);

    int deleteByExample(VipWaybillExample example);

    int deleteByPrimaryKey(@Param("userId") String userId, @Param("orderId") String orderId, @Param("billId") String billId);

    int insert(VipWaybill record);

    int insertSelective(VipWaybill record);

    List<VipWaybill> selectByExample(VipWaybillExample example);

    VipWaybill selectByPrimaryKey(@Param("userId") String userId, @Param("orderId") String orderId, @Param("billId") String billId);

    int updateByExampleSelective(@Param("record") VipWaybill record, @Param("example") VipWaybillExample example);

    int updateByExample(@Param("record") VipWaybill record, @Param("example") VipWaybillExample example);

    int updateByPrimaryKeySelective(VipWaybill record);

    int updateByPrimaryKey(VipWaybill record);
}