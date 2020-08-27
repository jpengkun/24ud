package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: vip_waybill
* @author outas
* @date 2019-12-10 15:02:51
*/
@Data
@ApiModel("vip用户的订单")
public class VipWaybill {
    @ApiModelProperty("vip用户id")
    private String userId;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("")
    private String billId;

    @ApiModelProperty("")
    private Date createTime;
}