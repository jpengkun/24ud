package cn.huaruan.ud24.vo;


import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindAddressBookParam extends PageParam {
    @ApiModelProperty("用户openId")
   private String openId;
    @ApiModelProperty("0代表发件人，1代表寄件人")
   private Integer state;
}
