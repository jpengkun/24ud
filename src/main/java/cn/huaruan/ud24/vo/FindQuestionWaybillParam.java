package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class FindQuestionWaybillParam extends PageParam {
    @ApiModelProperty("订单id")
    private String waybillId;
    @ApiModelProperty("类型 0：当日达 1：及时达")
    private Integer type;
    @ApiModelProperty("问题件类型")
    private String questionType;
    @ApiModelProperty("开始时间")
    private Date starTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("是否被处理 0:未处理，1已处理")
    private Integer status;

}
