package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: todays_courier
* @author outas
* @date 2019-12-07 16:21:33
*/
@Data
@ApiModel("当日达快递员")
public class TodaysCourier {
    @ApiModelProperty("主键、快递员id")
    private String id;

    @ApiModelProperty("快递员负责区域的id")
    private String areaId;

    @ApiModelProperty("证件类型")
    private String certificateType;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("紧急联系人")
    private String emergencyPeople;

    @ApiModelProperty("紧急联系人电话")
    private String emergencyPhone;

    @ApiModelProperty("工号")
    private String gid;

    @ApiModelProperty("头像")
    private String headPortrait;

    @ApiModelProperty("身份证号")
    private String identity;

    @ApiModelProperty("最后一次登陆时间")
    private Date loginTime;

    @ApiModelProperty("账户余额")
    private BigDecimal money;

    @ApiModelProperty("快递员名字")
    private String name;

    @ApiModelProperty("所属网点的id")
    private String oid;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("密码")
    private String phone;

    @ApiModelProperty("禁用备注")
    private String remark;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("认证状态：1已启用，0已禁用")
    private Integer state;

    @ApiModelProperty("今日收入")
    private BigDecimal income;
}