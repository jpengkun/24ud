package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: todays_waybill
* @author outas
* @date 2020-03-05 16:09:21
*/
@Data
@ApiModel("当日达运单")
public class TodaysWaybill {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("运单号")
    private String tdNo;

    @ApiModelProperty("目的地网点代码")
    private String destCode;

    @ApiModelProperty("始发网点id")
    private String startOrgId;

    @ApiModelProperty("目的网点id")
    private String destOrgId;

    @ApiModelProperty("运单来源/下单类型:1.代下单 2.客户下单 3.第三方导入")
    private Integer sourceType;

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

    @ApiModelProperty("备注信息")
    private String remarks;

    @ApiModelProperty("期望送达时间")
    private String expectArriveTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("下单用户open_id/vip用户id")
    private String openId;

    @ApiModelProperty("支付方式 1寄付 2到付")
    private Integer payType;

    @ApiModelProperty("付款状态")
    private Boolean payStatus;

    @ApiModelProperty("运费")
    private BigDecimal amount;

    @ApiModelProperty("信息确认无误")
    private Boolean confirm;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("第三方单号")
    private String thirdPartNo;
}