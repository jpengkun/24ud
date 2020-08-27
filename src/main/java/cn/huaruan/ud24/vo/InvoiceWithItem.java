package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.Invoice;
import cn.huaruan.ud24.query.entity.InvoiceWaybill;
import lombok.Data;

import java.util.List;

@Data
public class InvoiceWithItem extends Invoice {

    List<InvoiceWaybill> items;
}
