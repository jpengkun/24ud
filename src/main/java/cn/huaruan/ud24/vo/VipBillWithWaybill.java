package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.VipBill;
import lombok.Data;

import java.util.List;

@Data
public class VipBillWithWaybill extends VipBill {
    List<String> waybills;
}
