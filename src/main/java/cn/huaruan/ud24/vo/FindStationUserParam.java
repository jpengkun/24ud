package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindStationUserParam extends PageParam {

    @ApiModelProperty("站点id")
    private String oid;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("站点负责人名字")
    private String userName;
}
