package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SendMsgParam {

    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("加密后的验证码")
    private String hash;
    @ApiModelProperty("时间戳")
    private String tamp;
    @ApiModelProperty("用户输入的验证码")
    private String msgNum;
}
