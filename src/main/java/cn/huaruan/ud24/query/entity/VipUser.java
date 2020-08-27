package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* Created by Mybatis Generator 
* Table: vip_user
* @author outas
* @date 2019-12-09 19:54:10
*/
@Data
@ApiModel("vip用户")
public class VipUser {
    @ApiModelProperty("vip用户id")
    private String vUserId;

    @ApiModelProperty("状态 1.启用 0.禁用")
    private Integer state;

    @ApiModelProperty("类型 1.普通用户 0.系统管理员")
    private Integer type;

    @ApiModelProperty("用户名（唯一）")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("手机号")
    private String tel;

    @ApiModelProperty("创建时间")
    private Date createtime;
}