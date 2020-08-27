package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: timely_courier
* @author outas
* @date 2019-12-07 15:48:16
*/
@Data
@ApiModel("即时达快递员表")
public class TimelyCourier {
    @ApiModelProperty("即时达快递员id")
    private String id;

    @ApiModelProperty("即时达快递员名字")
    private String name;

    @ApiModelProperty("即时达快递员手机号")
    private String phone;

    @ApiModelProperty("即时达快递员紧急联系人")
    private String emergencyPeople;

    @ApiModelProperty("即时达快递员手机号")
    private String emergencyPhone;

    @ApiModelProperty("即时达证件类型")
    private String certificateType;

    @ApiModelProperty("即时达快递员身份证号")
    private String identity;

    @ApiModelProperty("毕业院校")
    private String school;

    @ApiModelProperty("学历")
    private String education;

    @ApiModelProperty("居住地址")
    private String address;

    @ApiModelProperty("押金")
    private BigDecimal deposit;

    @ApiModelProperty("头像")
    private String headPortrait;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("最后一次登陆时间")
    private Date loginTime;

    @ApiModelProperty("性别 女:0  男:1")
    private Integer sex;

    @JsonIgnore
    @ApiModelProperty("即时达快递员登陆密码")
    private String password;

    @ApiModelProperty("即时达禁用备注")
    private String remark;

    @ApiModelProperty("认证状态：1及时达未认证，2及时达已认证，0已禁用")
    private Integer state;

    @ApiModelProperty("今日收入")
    private BigDecimal income;

    @ApiModelProperty("身份证正面")
    private String front;

    @ApiModelProperty("身份证反面")
    private String back;

    @ApiModelProperty("毕业证照片")
    private String diploma;

    @ApiModelProperty("加盟商id")
    private String franchiseeId;

    @ApiModelProperty("钱包余额")
    private BigDecimal money;

    @ApiModelProperty("所负责的小超市")
    private String smallShopName;

    @ApiModelProperty("接单上限设置")
    private Integer cap;
}