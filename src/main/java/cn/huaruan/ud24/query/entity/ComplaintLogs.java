package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: complaint_logs
* @author outas
* @date 2019-11-27 10:07:17
*/
@Data
@ApiModel("投诉操作记录")
public class ComplaintLogs {
    @ApiModelProperty("操作记录id")
    private String logId;

    @ApiModelProperty("操作记录状态")
    private Integer logState;

    @ApiModelProperty("时间")
    private Date logTime;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("投诉用户")
    private String userName;

    @ApiModelProperty("投诉id")
    private String complaintId;
}