package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: vip_address
* @author outas
* @date 2019-12-09 19:54:10
*/
@Data
@ApiModel("vip地址簿")
public class VipAddress {
    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("关联的用户")
    private String userId;

    @ApiModelProperty("类型:1.收件人 2.寄件人")
    private Integer type;

    @ApiModelProperty("收/寄件人姓名")
    private String name;

    @ApiModelProperty("收/寄件人电话")
    private String tel;

    @ApiModelProperty("")
    private String address;

    @ApiModelProperty("收/寄件人国家/地区")
    private String city;

    @ApiModelProperty("收/寄件人邮编")
    private String postcode;

    @ApiModelProperty("收/寄件人证件类型")
    private Integer cardType;

    @ApiModelProperty("收/寄件人证件号")
    private String cardCode;

    @ApiModelProperty("备注")
    private String remark;
}