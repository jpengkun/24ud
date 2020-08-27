package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author outas
 */
@Data
public class FindUserParam extends PageParam {

    @ApiModelProperty(value = "用户名" )
    private String username;

    @ApiModelProperty(value = "昵称" )
    private String nickname;

    @ApiModelProperty(value = "网点id" )
    private String orgId;
}
