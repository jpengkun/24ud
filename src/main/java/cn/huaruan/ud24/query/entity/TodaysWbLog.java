package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: todays_wb_log
* @author outas
* @date 2019-12-03 14:12:55
*/
@Data
@ApiModel("当日达运单记录")
public class TodaysWbLog {
    @JsonIgnore
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("当日达运单id")
    private String wbId;

    @ApiModelProperty("快递员id")
    private String courierId;

    @ApiModelProperty("后台操作用户id")
    private String userId;

    @ApiModelProperty("下一站网点id")
    private String nextSiteId;

    @ApiModelProperty("状态[1:待取件, 2:待入库, 3:待运输, 4:运输中, 5:待出库, 6:派送中, 7:已签收, 99:异常件]")
    private Integer state;

    @ApiModelProperty("记录内容")
    private String detail;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("异常类型")
    private String abnormalType;

    @ApiModelProperty("快件当前所在网点id")
    private String orgId;

    @ApiModelProperty("图片url，多张用英文逗号隔开")
    private String img;

    @JsonIgnore
    public String getWbId() {
        return wbId;
    }

    @JsonProperty
    public void setWbId(String wbId) {
        this.wbId = wbId;
    }
}