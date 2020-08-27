package cn.huaruan.ud24.query.entity;

import cn.huaruan.ud24.vo.WaybillCharges;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import static java.math.BigDecimal.ROUND_DOWN;
import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Mybatis Generator
 * Table: quote_today
 *
 * @author outas
 * @date 2019-12-04 19:04:47
 */
@SuppressWarnings("all")
@Data
@ApiModel("当日达计价规则")
public class QuoteToday extends WaybillCharges {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("计重方式 1.实际重量   2.向上取整")
    private Integer weightMethod;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("组织架构id")
    private String oId;

    @ApiModelProperty("基础运费rmb")
    private BigDecimal basePrice;

    @ApiModelProperty("续重价格km/rmb")
    private BigDecimal additionalWeight;

    @ApiModelProperty("首重重量kg")
    private BigDecimal firstWeight;

    @ApiModelProperty("重量封顶kg")
    private BigDecimal topWeight;

    public static BigDecimal calWeightAmount(BigDecimal weight, QuoteToday quoteToday) {
//        BigDecimal amount = weight.divide(quoteToday.getTopWeight(), 0, ROUND_DOWN).multiply(quoteToday.getBasePrice().add(quoteToday.getTopWeight().subtract(quoteToday.getFirstWeight()).multiply(quoteToday.getAdditionalWeight())));
//        BigDecimal remainder = weight.divideAndRemainder(quoteToday.getTopWeight())[1];
        return weight.subtract(quoteToday.firstWeight).multiply(quoteToday.additionalWeight);
    }

}