package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("网点简要信息（用于作为选择下拉框）")
public class OrgSimpleVo {

    @ApiModelProperty("网点id")
    String id;
    @ApiModelProperty("网点名")
    String name;
}
