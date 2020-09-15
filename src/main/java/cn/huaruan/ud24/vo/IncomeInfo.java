package cn.huaruan.ud24.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 骑手收入等信息
 */
@Data
public class IncomeInfo {

    @ApiModelProperty("骑手id")
    private String id;

    @ApiModelProperty("今日收入")
    private BigDecimal income;

    @ApiModelProperty("评分")
    private Double grade;

    @ApiModelProperty("今日总订单")
    private Integer todayOrder;

    private Integer isOpen;

    @ApiModelProperty("骑手名字")
    private String courierName;

}
