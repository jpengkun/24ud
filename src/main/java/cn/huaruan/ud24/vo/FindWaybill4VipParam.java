package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * @author outas
 */
@Data
@ApiModel("vip订单查询参数")
public class FindWaybill4VipParam extends PageParam {

    @ApiModelProperty(value = "运单编号")
    private String wbNo;

    @ApiModelProperty(value = "状态-1 ")
    private Integer state;

    @ApiModelProperty(value = "vip用户id")
    private String vipUserId;

    @ApiModelProperty(value = "1普通用户 0管理员")
    private Integer type;

}
