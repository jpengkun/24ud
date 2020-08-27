package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindInvoiceParam extends PageParam {
    @ApiModelProperty("小程序id")
    private String openId;
}
