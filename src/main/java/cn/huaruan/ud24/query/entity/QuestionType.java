package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: question_type
* @author outas
* @date 2019-11-30 14:28:36
*/
@Data
@ApiModel("")
public class QuestionType {
    @ApiModelProperty("类型id")
    private Integer id;

    @ApiModelProperty("类型内容")
    private String typeContent;
}