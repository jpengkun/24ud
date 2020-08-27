package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FindWithdrawalAuditParam extends PageParam {

    @ApiModelProperty("快递员名字")
    private String courierName;
    @ApiModelProperty("状态(0:代操作，1:已操作)")
    private Integer status;
    @ApiModelProperty("开始时间")
    private Date starTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
}
