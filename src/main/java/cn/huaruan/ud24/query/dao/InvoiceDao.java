package cn.huaruan.ud24.query.dao;


import cn.huaruan.ud24.query.entity.Invoice;
import cn.huaruan.ud24.query.mapper.InvoiceMapper;
import cn.huaruan.ud24.vo.FindInvoiceParam;
import cn.huaruan.ud24.vo.InvoiceWithItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends InvoiceMapper {

    long countInvoice(FindInvoiceParam invoiceParam);

    List<InvoiceWithItem> findByOpenId(FindInvoiceParam invoiceParam);

}
