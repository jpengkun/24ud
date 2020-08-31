package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* Created by Mybatis Generator 
* Table: complaint
* @author outas
* @date 2019-12-03 18:18:44
*/
@Data
@ApiModel("投诉管理")
public class Complaint {
    @ApiModelProperty("投诉id")
    private String id;

    @ApiModelProperty("类别(1.当日达  2.即时达)")
    private String category;

    @ApiModelProperty("投诉创建时间")
    private Date createTime;

    @ApiModelProperty("投诉详情描述")
    private String detail;

    @ApiModelProperty("投诉的状态(1.未处理,2.处理中;3.客诉成功 0已取消)")
    private Integer state;

    @ApiModelProperty("投诉发起人的电话")
    private String tel;

    @ApiModelProperty("投诉类型")
    private String type;

    @ApiModelProperty("被投诉的运单id")
    private String waybillId;

    @ApiModelProperty("")
    private String openId;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("销单原因")
    private String destroyCause;

    @ApiModelProperty("投诉的状态(状态[1:待接单, 2:待取件, 3:已取件, 4:派送中, 5:待签收, 6:已签收, 7:转单, 10:异常件])")
    private Integer timelyWbLogState;
}