package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: timely_wb_log
* @author outas
* @date 2019-12-03 14:12:55
*/
@Data
@ApiModel("即时达运单记录")
public class TimelyWbLog {
    @JsonIgnore
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("即时达运单id")
    private String wbId;

    @ApiModelProperty("即时达快递员id")
    private String courierId;

    @ApiModelProperty("状态[1:待接单, 2:待取件, 3:已取件, 4:派送中, 5:待签收, 6:已签收, 7:转单, 99:异常件]")
    private Integer state;

    @ApiModelProperty("记录内容")
    private String detail;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("签收时间")
    private Date closedTime;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("异常类型")
    private String abnormalType;

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