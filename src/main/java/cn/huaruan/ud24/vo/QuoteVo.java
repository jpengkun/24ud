package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

import java.math.BigDecimal;

@Data
public class QuoteVo {

    String oid;
    BigDecimal weight;
    BigDecimal distance;
    @ApiModelProperty("地图坐标")
    private Polygon polygon;
    private Point point;

}

