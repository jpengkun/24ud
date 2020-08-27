package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindExpectTimeParam extends PageParam {

    @ApiModelProperty("网点id")
    private String oid;
}
