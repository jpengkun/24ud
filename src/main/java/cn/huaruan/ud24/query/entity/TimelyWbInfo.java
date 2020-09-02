package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author user
 */
@Data
public class TimelyWbInfo extends PageHai {
    @JsonIgnore
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("即时达运单id")
    private String wbId;

    @ApiModelProperty("即时达快递员id")
    private String courierId;

    @ApiModelProperty("状态[4:派送中, 6:已签收,  99:异常件]")
    private Integer state;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("寄件人姓名")
    private String sender;

    @ApiModelProperty("寄件人电话")
    private String senderPhone;

    @ApiModelProperty("配送费")
    private BigDecimal amount;

    @ApiModelProperty("寄件地址")
    private String senderAddress;

    @ApiModelProperty("收件人姓名")
    private String receiver;

    @ApiModelProperty("收件人电话")
    private String receiverPhone;

    @ApiModelProperty("收件地址")
    private String receiverAddress;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("异常类型")
    private String abnormalType;

    @ApiModelProperty("图片url，多张用英文逗号隔开")
    private String img;

    @ApiModelProperty("配送所用时间")
    private Long totalTime;

}
