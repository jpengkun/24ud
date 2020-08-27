package cn.huaruan.ud24.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class WaybillCharges {
    BigDecimal weight;
    BigDecimal distance;
    BigDecimal weightAmount;
    BigDecimal baseAmount;
    BigDecimal totalAmount;
}
