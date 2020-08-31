package cn.huaruan.ud24.query.entity;

import cn.huaruan.ud24.application.query.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TimelyUtil
 * @Description TODO
 * @Author zdf82
 * @Date 2020/8/31 15:53
 **/
@Data
@ApiModel("历史接单工具类")
public class TimelyUtil  {
    private Integer pageNo;

    private Integer pageSize;

    @ApiModelProperty("骑手id")
    private String riderId;

    @ApiModelProperty("年")
    private String years;

    @ApiModelProperty("月")
    private String month;

}
