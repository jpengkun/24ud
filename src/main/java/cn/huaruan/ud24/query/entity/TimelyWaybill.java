package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: timely_waybill
* @author outas
* @date 2019-12-09 00:15:59
*/
@Data
@ApiModel("及时达运单")
public class TimelyWaybill {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("运单号")
    private String tmNo;

    @ApiModelProperty("所在网点id")
    private String orgId;

    @ApiModelProperty("寄件人姓名")
    private String sender;

    @ApiModelProperty("寄件人电话")
    private String senderPhone;

    @ApiModelProperty("寄件地址")
    private String senderAddress;

    @ApiModelProperty("下单人位置经纬度")
    private Object senderLocation;

    @ApiModelProperty("收件人姓名")
    private String receiver;

    @ApiModelProperty("收件人电话")
    private String receiverPhone;

    @ApiModelProperty("收件地址")
    private String receiverAddress;

    @ApiModelProperty("收货人位置经纬度")
    private Object receiverLocation;

    @ApiModelProperty("货物重量")
    private BigDecimal goodsWeight;

    @ApiModelProperty("货物信息")
    private String goodsInfo;

    @ApiModelProperty("下单人open_id")
    private String openId;

    @ApiModelProperty("备注信息")
    private String remarks;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建时间")
    private Date updateTime;

    @ApiModelProperty("支付方式 1寄付 2到付")
    private Integer payType;

    @ApiModelProperty("支付状态")
    private Boolean payStatus;

    @ApiModelProperty("运费")
    private BigDecimal amount;

    @ApiModelProperty("信息确认无误")
    private Boolean confirm;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("小超id")
    private String smallShopId;

    @ApiModelProperty("骑手id")
    private String riderId;

}