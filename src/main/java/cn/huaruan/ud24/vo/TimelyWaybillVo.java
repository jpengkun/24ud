package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TimelyWaybill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.geo.Point;

/**
 * 说明：Generator生成的实体类无法直接处理特殊数据类型
 * 因此使用typeHandler处理特殊数据类型，并覆盖、屏蔽掉原字段
 * @author outas
 */
@Data
public class TimelyWaybillVo extends TimelyWaybill {

    @ApiModelProperty("下单人位置经纬度")
    private Point senderLocation;

    @ApiModelProperty("收件人位置经纬度")
    private Point receiverLocation;
}
