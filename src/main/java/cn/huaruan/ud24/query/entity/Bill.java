package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: bill
* @author outas
* @date 2019-12-08 00:50:53
*/
@Data
@ApiModel("流水账单表")
public class Bill {
    @ApiModelProperty("流水主键")
    private Integer id;

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("单笔流水金额")
    private BigDecimal money;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("类型（1收入，0支出）")
    private Integer type;

    @ApiModelProperty("快递员类型(0:当日达1:及时达)")
    private Integer genre;

    @ApiModelProperty("流水状态0：待审核1：已通过 3:提现驳回")
    private Integer status;

    @ApiModelProperty("银行卡号")
    private String cardNum;

    @ApiModelProperty("银行名称")
    private String bankName;

    @ApiModelProperty("银行地址")
    private String bankAddress;

    @ApiModelProperty("银行预留手机号")
    private String phone;
}