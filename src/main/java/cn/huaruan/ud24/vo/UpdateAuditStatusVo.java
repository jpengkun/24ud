package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateAuditStatusVo {
    @ApiModelProperty("快递员id")
    private List<String> courierIds;
    @ApiModelProperty("状态(0:代操作，1:已操作)")
    private Integer status;
}
