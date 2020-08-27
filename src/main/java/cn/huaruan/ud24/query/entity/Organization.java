package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: organization
* @author outas
* @date 2019-11-29 17:10:05
*/
@Data
@ApiModel("组织架构")
public class Organization {
    @ApiModelProperty("网点id")
    private String id;

    @ApiModelProperty("站点名称")
    private String name;

    @ApiModelProperty("网点编号")
    private String code;

    @ApiModelProperty("负责人")
    private String leader;

    @ApiModelProperty("负责人电话")
    private String leaderTel;

    @ApiModelProperty("等级[0总部 1省级 2市级 3分拨中心 4站点 5区域]")
    private Integer level;

    @ApiModelProperty("网点模式")
    private Integer mode;

    @ApiModelProperty("类型")
    private Integer type;

    @JsonIgnore
    @ApiModelProperty("地图坐标")
    private Object polygon;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("父网点id")
    private String parentId;

    @ApiModelProperty("创建时间")
    private Date createTime;
}