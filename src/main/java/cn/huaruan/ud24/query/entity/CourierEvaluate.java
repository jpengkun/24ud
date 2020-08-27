package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
* Created by Mybatis Generator 
* Table: courier_evaluate
* @author outas
* @date 2019-11-25 15:25:03
*/
@Data
@ApiModel("快递员评价")
public class CourierEvaluate {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("评价内容")
    private String evaluate;

    @ApiModelProperty("得分")
    private BigDecimal score;

    @ApiModelProperty("即时达快递员id")
    private String timelyId;
}