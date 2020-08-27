package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: finance_timely
* @author outas
* @date 2019-12-03 19:19:45
*/
@Data
@ApiModel("加盟商即使达分成")
public class FinanceTimely{
    @ApiModelProperty("id")
    private String timelyId;

    @ApiModelProperty("总部分成")
    private Double center;

    @ApiModelProperty("分拨中心分成")
    private Double allocation;

    @ApiModelProperty("站点分成")
    private Double site;

    @ApiModelProperty("业务员分成")
    private Double courier;

    @ApiModelProperty("组织架构id")
    private String oId;
}