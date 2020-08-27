package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TodaysCourier;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ToCourierWithScore extends TodaysCourier {
    private BigDecimal score;
}
