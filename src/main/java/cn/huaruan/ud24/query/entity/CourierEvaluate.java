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
    private String id;

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("评价内容")
    private String evaluate;

    @ApiModelProperty("得分")
    private BigDecimal score;

    @ApiModelProperty("即时达快递员id")
    private String timelyId;

    @ApiModelProperty("运单id")
    private String wbId;

    @ApiModelProperty("骑手收益")
    private Double riderGains;

    @ApiModelProperty("快递员名字")
    private String courierName;

    @ApiModelProperty("物流单号")
    private String logisticsNumber;

    @ApiModelProperty("评论图片")
    private String courierImgUrl;
}