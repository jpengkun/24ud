package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class FindCourierParam extends PageParam {
    @ApiModelProperty("快递员姓名")
    private String name;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("状态")
    private Integer state;
    @ApiModelProperty("所属区域Id")
    private String areaId;
    @ApiModelProperty("所属网点id")
    private String oid;
}
