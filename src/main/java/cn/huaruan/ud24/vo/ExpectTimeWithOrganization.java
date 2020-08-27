package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.ExpectTime;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExpectTimeWithOrganization {
    @ApiModelProperty("站点id")
    private String oid;
    @ApiModelProperty("站点父级id，添加不用传")
    private String pid;
    @ApiModelProperty("网点名字，添加不用传")
    private String name;
    @ApiModelProperty("班车时间数组")
    private List<ExpectTime> times;
    @ApiModelProperty("用来装成树状")
    private List<ExpectTimeWithOrganization> children;

}
