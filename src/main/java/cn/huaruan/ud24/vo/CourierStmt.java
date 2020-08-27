package cn.huaruan.ud24.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CourierStmt {

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("快递员名字")
    private String courierName;

    @ApiModelProperty("未完成")
    private List<String> todo;

    @ApiModelProperty("已完成")
    private List<String> done;

    @ApiModelProperty("异常")
    private List<String> abnormal;

    @ApiModelProperty("取消")
    private List<String> cancel;
}
