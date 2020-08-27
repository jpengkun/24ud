package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FindEvaluateAboutCourierParam extends PageParam {
    @ApiModelProperty("快递员id")
    private String courierId;
    @ApiModelProperty("即时达快递员id")
    private String timelyId;
}
