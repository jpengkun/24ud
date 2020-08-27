package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.TimelyWbLog;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TimelyWbLogVo extends TimelyWbLog {
    @ApiModelProperty("当日达运单号(说明：优先级比id低，当两个参数都传时，使用id进行扫描)")
    private String wbNo;
}
