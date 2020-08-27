package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateCourierStateVo {
    @ApiModelProperty("id")
    private List<String> ids;
    @ApiModelProperty("状态")
    private Integer state;
}
