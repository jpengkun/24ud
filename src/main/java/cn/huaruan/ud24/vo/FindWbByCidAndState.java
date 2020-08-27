package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("快递员运单列表条件")
public class FindWbByCidAndState extends PageParam {

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("运单状态")
    private Integer state;
}
