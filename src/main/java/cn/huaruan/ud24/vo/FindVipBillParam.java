package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FindVipBillParam extends PageParam {

    @ApiModelProperty("关联的用户")
    private String userId;

    @ApiModelProperty("支付状态 1.已支付 0.未支付")
    private Integer paymentState;

    @ApiModelProperty("开始时间")
    private Date starTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
