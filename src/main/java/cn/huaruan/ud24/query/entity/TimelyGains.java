package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *骑手收益表实体类
 * @ClassName TimelyGains
 * @Description TODO
 * @Author zdf82
 * @Date 2020/9/9 19:31
 **/
@Data
public class TimelyGains {

    private String id;

    @ApiModelProperty("即时达快递员id")
    private String courierId;

    @ApiModelProperty("运单id")
    private String wbId;

    @ApiModelProperty("运单收益")
    private Double riderGains;

    @ApiModelProperty("收益规则")
    private Double rule;
}
