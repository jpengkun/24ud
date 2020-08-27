package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class TodaysWbWithLogs extends TodaysWaybillVo{

    @ApiModelProperty("起始站点网点名")
    private String startOrgName;

    @ApiModelProperty("目的地站点网点名")
    private String destOrgName;

    @ApiModelProperty("运单操作记录")
    private List<TodaysWbLogWithCourInfo> logs;
}
