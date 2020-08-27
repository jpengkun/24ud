package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * @author outas
 */
@Data
@ApiModel("订单查询参数")
public class FindWaybillParam extends PageParam {

    @ApiModelProperty(value = "运单编号")
    private String wbNo;

    @ApiModelProperty(value = "运单编号（批量查询）")
    private List<String> wbNoList;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "网点id")
    private String orgId;

    @ApiModelProperty(value = "目的网点id")
    private String destOrgId;

    @ApiModelProperty(value = "寄件人姓名")
    private String sender;

    @ApiModelProperty(value = "寄件人电话")
    private String senderPhone;

    @ApiModelProperty(value = "寄件人地址")
    private String senderAddress;

    @ApiModelProperty(value = "收件人姓名")
    private String receiver;

    @ApiModelProperty(value = "收件人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "收件人地址")
    private String receiverAddress;

    @ApiModelProperty(value = "最后操作时间开始")
    private Date lastOpTimeStart;

    @ApiModelProperty(value = "最后操作时间结束")
    private Date lastOpTimeEnd;

    @ApiModelProperty(value = "创建时间开始")
    private Date createTimeStart;

    @ApiModelProperty(value = "创建时间结束")
    private Date createTimeEnd;

    @ApiModelProperty(value = "是否转运0否 1是 不传查全部")
    private Integer transfer;

    @ApiModelProperty(value = "第三方单号")
    private String thirdPartNo;

}
