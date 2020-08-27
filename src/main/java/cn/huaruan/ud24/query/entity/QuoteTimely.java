package cn.huaruan.ud24.query.entity;

import cn.huaruan.ud24.vo.WaybillCharges;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by Mybatis Generator
 * Table: quote_timely
 *
 * @author outas
 * @date 2019-12-04 19:04:09
 */
@SuppressWarnings("all")
@Data
@ApiModel("即时达计价规则")
public class QuoteTimely extends WaybillCharges {
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("计重方式 1.实际重量 2.向上取整")
    private Integer weightMethod;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("组织架构id")
    private String oId;

    @ApiModelProperty("基础运费rmb")
    private BigDecimal basePrice;

    @ApiModelProperty("首重重量kg")
    private BigDecimal firstWeight;

    @ApiModelProperty("续重价格kg/rmb")
    private BigDecimal additionalWeight;

    @ApiModelProperty("重量封顶kg")
    private BigDecimal topWeight;

    @ApiModelProperty("第一段路程区间km")
    private BigDecimal firstDistance;

    @ApiModelProperty("第一段路程区间价格rmb")
    private BigDecimal firstDistancePrice;

    @ApiModelProperty("第二段路程区间km")
    private BigDecimal secondDistance;

    @ApiModelProperty("第二段路程价格rmb")
    private BigDecimal secondDistancePrice;

    @ApiModelProperty("距离附加费km/rmb")
    private BigDecimal additionalDistance;

    public static BigDecimal calWeightAmount(BigDecimal weight, QuoteTimely quoteTimely) {
        BigDecimal amount = weight.divide(quoteTimely.getTopWeight(),0,ROUND_HALF_UP).multiply(quoteTimely.getBasePrice().add(quoteTimely.getTopWeight().subtract(quoteTimely.getFirstWeight()).multiply(quoteTimely.getAdditionalWeight())));
        BigDecimal remainder = weight.divideAndRemainder(quoteTimely.getTopWeight())[1];
        if (remainder.compareTo(quoteTimely.getFirstWeight()) == 1) {
            amount = amount.add(remainder.subtract(quoteTimely.firstWeight).multiply(quoteTimely.additionalWeight));
        }
        return amount;
    }


    public static BigDecimal calBaseAmount(BigDecimal distance, QuoteTimely quoteTimely) {
        BigDecimal amount = new BigDecimal(0);
        if (distance.compareTo(quoteTimely.firstDistance) == -1) {
            amount = amount.add(quoteTimely.firstDistancePrice);
        } else if (distance.compareTo(quoteTimely.secondDistance) == -1) {
            amount = amount.add(quoteTimely.secondDistancePrice);
        } else {
            amount =amount.add(quoteTimely.secondDistancePrice.add((distance.subtract(quoteTimely.secondDistance)).multiply(quoteTimely.additionalDistance)));
        }
        return amount;
    }
}