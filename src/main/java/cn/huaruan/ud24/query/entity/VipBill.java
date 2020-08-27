package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: vip_bill
* @author outas
* @date 2019-12-10 15:02:51
*/
@Data
@ApiModel("vip流水")
public class VipBill {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("关联的用户")
    private String userId;

    @ApiModelProperty("支付状态 1.已支付 0.未支付")
    private Integer paymentState;

    @ApiModelProperty("件数")
    private Integer count;

    @ApiModelProperty("")
    private BigDecimal amount;

    @ApiModelProperty("账单生成时间")
    private Date createTime;
}