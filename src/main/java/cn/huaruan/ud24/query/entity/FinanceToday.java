package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: finance_today
* @author outas
* @date 2019-12-03 19:19:56
*/
@Data
@ApiModel("加盟商当日达分成")
public class FinanceToday{
    @ApiModelProperty("id")
    private String todayId;

    @ApiModelProperty("总部分成")
    private Double center;

    @ApiModelProperty("分拨中心分成")
    private Double allocation;

    @ApiModelProperty("寄件网点分成")
    private Double sendSite;

    @ApiModelProperty("派件网点分成")
    private Double receiveSite;

    @ApiModelProperty("收件员分成")
    private Double picker;

    @ApiModelProperty("派件员分成")
    private Double deliver;

    @ApiModelProperty("干线分成")
    private Double transportation;

    @ApiModelProperty("组织架构id")
    private String oId;
}