package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindVipUserParam extends PageParam {
    @ApiModelProperty("状态 1.启用 0.禁用")
    private Integer state;
    @ApiModelProperty("用户名（唯一）")
    private String userName;
    @ApiModelProperty("手机号")
    private String tel;
    @ApiModelProperty("类型 1.普通用户 0.系统管理员")
    private Integer type;
}
