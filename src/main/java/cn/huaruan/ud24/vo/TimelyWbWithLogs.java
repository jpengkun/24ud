package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class TimelyWbWithLogs extends TimelyWaybillVo{

    @ApiModelProperty("网点名")
    private String orgName;

    @ApiModelProperty("运单操作记录")
    private List<TimelyWbLogWithCourInfo> logs;
}
