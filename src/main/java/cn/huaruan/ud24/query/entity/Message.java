package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: message
* @author outas
* @date 2019-12-18 18:55:39
*/
@Data
@ApiModel("系统消息")
public class Message {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("类型 1.未指派取件人")
    private Integer type;

    @ApiModelProperty("状态 1.已读 0.未读")
    private Integer state;

    @ApiModelProperty("详细信息")
    private String detail;

    @ApiModelProperty("关联的订单id")
    private String waybillId;

    @ApiModelProperty("创建日期")
    private Date createTime;
}