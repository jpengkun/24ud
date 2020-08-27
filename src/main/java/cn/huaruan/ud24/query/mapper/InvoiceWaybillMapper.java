package cn.huaruan.ud24.query.mapper;

import cn.huaruan.ud24.query.entity.InvoiceWaybill;
import cn.huaruan.ud24.query.entity.InvoiceWaybillExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 
* @author outas
* @date 2019-12-02 18:08:29
*/
@Mapper
public interface InvoiceWaybillMapper {
    long countByExample(InvoiceWaybillExample example);

    int deleteByExample(InvoiceWaybillExample example);

    int insert(InvoiceWaybill record);

    int insertSelective(InvoiceWaybill record);

    List<InvoiceWaybill> selectByExample(InvoiceWaybillExample example);

    int updateByExampleSelective(@Param("record") InvoiceWaybill record, @Param("example") InvoiceWaybillExample example);

    int updateByExample(@Param("record") InvoiceWaybill record, @Param("example") InvoiceWaybillExample example);
}