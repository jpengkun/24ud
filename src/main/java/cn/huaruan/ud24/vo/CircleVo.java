package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.geo.Point;

/**
 * 范围查找用的圆的参数
 * @author outas
 */
@Data
@ApiModel("范围查找用的圆的参数")
@AllArgsConstructor
public class CircleVo extends PageParam {
    @ApiModelProperty("快递员当前位置坐标")
    private Point point;

    @ApiModelProperty("半径范围，单位m")
    private Double radius;

    @ApiModelProperty("状态")
    private Integer state;
}
