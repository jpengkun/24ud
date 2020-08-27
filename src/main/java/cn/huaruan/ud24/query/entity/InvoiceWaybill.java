package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: invoice_waybill
* @author outas
* @date 2019-12-02 18:08:29
*/
@Data
@ApiModel("发票运单")
public class InvoiceWaybill {
    @ApiModelProperty("发票id")
    private String invoiceId;

    @ApiModelProperty("运单id")
    private String waybillId;

    @ApiModelProperty("金额")
    private BigDecimal amount;
}