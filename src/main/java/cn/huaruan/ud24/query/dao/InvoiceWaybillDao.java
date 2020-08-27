package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.InvoiceWaybill;
import cn.huaruan.ud24.query.mapper.InvoiceWaybillMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceWaybillDao extends InvoiceWaybillMapper {
    int insertInvoiceItems(List<InvoiceWaybill> invoiceItems);
}
