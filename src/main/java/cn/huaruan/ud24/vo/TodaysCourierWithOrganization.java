package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TodaysCourier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TodaysCourierWithOrganization extends TodaysCourier {

    @ApiModelProperty("网点名")
    private String orgName;

    @ApiModelProperty("区域名")
    private String areaName;

}
