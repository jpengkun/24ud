package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindTimelyCourierParam extends PageParam {

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("认证状态")
    private String state;

}
