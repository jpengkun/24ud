package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
public class FindComplaintParam extends PageParam {

    @ApiModelProperty(value = "投诉id" )
    private String id;
    @ApiModelProperty(value = "投诉人的id" )
    private String openId;
    @ApiModelProperty(value = "类型" )
    private String type;
    @ApiModelProperty(value = "投诉的状态(1.未处理,2.处理中;3.客诉成功 0已取消)" )
    private Integer state;
    @ApiModelProperty("类别(1.当日达  2.即时达)")
    private String category;
    @ApiModelProperty(value = "创建时间开始" )
    private Date createTimeStart;
    @ApiModelProperty(value = "创建时间结束" )
    private Date createTimeEnd;
    @ApiModelProperty(value = "被投诉的运单编号")
    private Integer waybillId;

}
