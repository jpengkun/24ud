package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TimelyCourier;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TiCourierWithScore extends TimelyCourier {
    private BigDecimal score;
}
