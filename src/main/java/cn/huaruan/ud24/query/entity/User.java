package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 
* Table: user
* @author outas
* @date 2019-12-13 16:13:36
*/
@Data
@ApiModel("用户")
public class User {
    @ApiModelProperty("主键")
    private String userId;

    @ApiModelProperty("关联的网点id")
    private String orgId;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("状态")
    private Boolean status;

    @ApiModelProperty("操作人所属网点id")
    private String operateOrgId;
}