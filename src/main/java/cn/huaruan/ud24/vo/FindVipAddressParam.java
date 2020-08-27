package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindVipAddressParam extends PageParam {
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("类型:1.收件人 2.寄件人")
    private Integer type;
    @ApiModelProperty("收/寄件人姓名")
    private String name;
}
