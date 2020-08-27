package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* Created by Mybatis Generator 
* Table: notice
* @author outas
* @date 2019-12-04 15:45:13
*/
@Data
@ApiModel("公告")
public class Notice {
    @ApiModelProperty("公告id")
    private String id;

    @ApiModelProperty("公告类型(1.app公告  2.后台管理公告)")
    private Integer category;

    @ApiModelProperty("发布时间")
    private Date createTime;

    @ApiModelProperty("持续时间")
    private Date lastTime;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("浏览次数")
    private Integer count;

    @ApiModelProperty("主图路径")
    private String img;

    @ApiModelProperty("状态(1.未发布 2.已发布 3.已下线 0.已过期)")
    private Integer state;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("类型")
    private String type;
}