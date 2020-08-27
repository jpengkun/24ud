package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: expect_time
* @author outas
* @date 2019-12-01 14:19:52
*/
@Data
@ApiModel("期望送达时间/班车时间")
public class ExpectTime {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("网点id")
    private String oid;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;

    @JsonIgnore
    public String getOid() {
        return oid;
    }

    @JsonProperty
    public void setOid(String oid) {
        this.oid = oid;
    }
}