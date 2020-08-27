package cn.huaruan.ud24.security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 登录请求参数
 * @author outas
 */
@Data
@ApiModel("登录参数")
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("后台:用户名 快递员端:手机号")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 记住我
     */
    @ApiModelProperty("记住我,默认为false,token只保留一小时,为true时保留一周")
    private Boolean rememberMe = false;

    /**
     * 账户类型
     */
    @NotNull(message = "登录账户类型不能为空！(0后台 1当日达小程序 2即时达小程序)")
    @ApiModelProperty("账户类型 0后台 1当日达小程序 2即时达小程序")
    private Integer type;

}
