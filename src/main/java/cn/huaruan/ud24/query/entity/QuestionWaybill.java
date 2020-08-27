package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: question_waybill
* @author outas
* @date 2019-12-05 19:53:05
*/
@Data
@ApiModel("问题件")
public class QuestionWaybill {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("订单id")
    private String waybillId;

    @ApiModelProperty("问题件类型")
    private String questionType;

    @ApiModelProperty("问题件是否被处理：0：未处理 1：已处理")
    private Integer questionStatus;

    @ApiModelProperty("问题详情")
    private String questionDetails;

    @ApiModelProperty("解决方案，由客服处理解决")
    private String solution;

    @ApiModelProperty("备注")
    private String remake;

    @ApiModelProperty("问题图片1")
    private String img1;

    @ApiModelProperty("问题图片2")
    private String img2;

    @ApiModelProperty("问题图片3")
    private String img3;

    @ApiModelProperty("问题图片4")
    private String img4;

    @ApiModelProperty("类型，0：当日达 1:及时达")
    private Integer type;

    @ApiModelProperty("创建时间")
    private Date creatTime;
}