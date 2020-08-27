package cn.huaruan.ud24.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WaybillVo {
    private String id;
    private String openId;
    private String tmNo;
    private String tdNo;
    private String no;
    private BigDecimal amount;
    private Boolean confirm;
}
