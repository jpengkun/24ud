package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: complaint_type
* @author outas
* @date 2019-12-03 16:07:20
*/
@Data
@ApiModel("投诉类型管理")
public class ComplaintType {
    @ApiModelProperty("id")
    private String typeId;

    @ApiModelProperty("类型名称")
    private String typeName;

    @ApiModelProperty("上级投诉类型")
    private String pid;
}