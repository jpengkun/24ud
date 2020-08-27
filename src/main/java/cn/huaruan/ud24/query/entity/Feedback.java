package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: feedback
* @author outas
* @date 2019-11-25 11:34:51
*/
@Data
@ApiModel("意见反馈")
public class Feedback {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("建议内容")
    private String suggest;

    @ApiModelProperty("联系电话")
    private String tel;
}