package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FindMessageParam extends PageParam {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("推送的用户id")
    private String userId;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("类型 1.未指派取件人")
    private Integer type;

    @ApiModelProperty("状态  1.已读  0.未读")
    private Integer state;

    @ApiModelProperty("详细信息")
    private String detail;

    @ApiModelProperty("关联的订单id")
    private String waybillId;

    @ApiModelProperty("创建日期")
    private Date createTime;
}
