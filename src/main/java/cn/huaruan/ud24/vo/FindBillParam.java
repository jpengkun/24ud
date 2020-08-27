package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FindBillParam extends PageParam {
    @ApiModelProperty("快递员id")
    private String courierId;
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("开始时间")
    private Date starTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("状态")
    private Integer status;
}
