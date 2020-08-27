package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: invoice
* @author outas
* @date 2019-12-02 17:12:46
*/
@Data
@ApiModel("发票")
public class Invoice {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("抬头（必填）")
    private String title;

    @ApiModelProperty("税号（抬头类型为企业单位时必填）")
    private String taxNum;

    @ApiModelProperty("用于接收发票的电子邮箱（邮箱手机号二者必填其一）")
    private String email;

    @ApiModelProperty("用于接收发票的手机号（邮箱手机号二者必填其一）")
    private String tel;

    @ApiModelProperty("小程序openId（必填）")
    private String openId;

    @ApiModelProperty("地址和电话（选填）")
    private String addressAndPhoneNum;

    @ApiModelProperty("开户行和帐号（选填）")
    private String bankAndNum;

    @ApiModelProperty("备注说明（选填）")
    private String remark;

    @ApiModelProperty("开票成功生成的PDF的URL")
    private String pdfUrl;

    @ApiModelProperty("开票成功生成的收票URL（可生成为二维码）")
    private String invoiceUrl;

    @ApiModelProperty("发票号码")
    private String invoiceNum;

    @ApiModelProperty("发票代码")
    private String invoiceCode;

    @ApiModelProperty("开票日期")
    private Date createTime;
}