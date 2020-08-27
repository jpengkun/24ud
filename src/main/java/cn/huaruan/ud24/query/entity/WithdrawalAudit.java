package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: withdrawal_audit
* @author outas
* @date 2019-12-08 00:50:53
*/
@Data
@ApiModel("提现审核")
public class WithdrawalAudit {
    @ApiModelProperty("提现审核主键")
    private Integer id;

    @ApiModelProperty("快递员名字")
    private String courierName;

    @ApiModelProperty("提现金额")
    private BigDecimal money;

    @ApiModelProperty("申请时间")
    private Date applyTime;

    @ApiModelProperty("状态(0:代操作，1:已操作)")
    private Integer status;

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("银行卡号")
    private String cardNum;

    @ApiModelProperty("快递员类型(0:当日达1:及时达)")
    private Integer genre;

    @ApiModelProperty("银行名称")
    private String bankName;

    @ApiModelProperty("银行地址")
    private String bankAddress;

    @ApiModelProperty("银行预留手机号")
    private String phone;
}