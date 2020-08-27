package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.VipBill;
import cn.huaruan.ud24.query.entity.VipBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-10 15:02:51
*/
@Mapper
public interface VipBillMapper {
    long countByExample(VipBillExample example);

    int deleteByExample(VipBillExample example);

    int deleteByPrimaryKey(String id);

    int insert(VipBill record);

    int insertSelective(VipBill record);

    List<VipBill> selectByExample(VipBillExample example);

    VipBill selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VipBill record, @Param("example") VipBillExample example);

    int updateByExample(@Param("record") VipBill record, @Param("example") VipBillExample example);

    int updateByPrimaryKeySelective(VipBill record);

    int updateByPrimaryKey(VipBill record);
}