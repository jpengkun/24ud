package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class IdCards {

    @ApiModelProperty("身份证方向 1正面 2反面")
    private Integer side;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("生日")
    private String birthday;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("身份证号")
    private String number;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("民族")
    private String nation;
    @ApiModelProperty("图片路径")
    private String path;
}
