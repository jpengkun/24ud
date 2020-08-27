package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: station_user
* @author outas
* @date 2019-12-02 10:12:29
*/
@Data
@ApiModel("站点巴枪账号")
public class StationUser {
    @ApiModelProperty("站点账号id")
    private String id;

    @ApiModelProperty("所属站点id")
    private String oid;

    @ApiModelProperty("账号归属人")
    private String userName;

    @ApiModelProperty("手机号，也是登陆账号")
    private String phone;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("所属站点名字")
    private String orgName;
}