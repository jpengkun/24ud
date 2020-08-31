/**
 * File Name:UserJpushRel
 * Package Name:com.huaruan.woho.mapper.entity
 * Date:2020-05-15
 * Copyright (c) 2019, http://www.cspos.com All Rights Reserved.
 *
 */
package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import sun.dc.pr.PRError;

import java.io.Serializable;

/**
 * Table: woho_user_jpush_rel <br/>
 * Description:  <br/>
 * date: 2020-05-15 <br/>
 * 
 * @author generator
 * @version
 * @since JDK 1.8
 */
@SuppressWarnings("serial")
@ApiModel(value="")
@Data
public class UserJpushRel extends BaseEntity<Serializable> {
    private String id;

    /**
     * 用户id
     */
    @ApiModelProperty(value ="用户id")
    private String userId;

    /**
     * 设备唯一标识
     */
    @ApiModelProperty(value ="设备唯一标识")
    private String registrationId;

    /**
     * 用户id
     * @return user_id 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 设备唯一标识
     * @return registration_id 设备唯一标识
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * 设备唯一标识
     * @param registrationId 设备唯一标识
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId == null ? null : registrationId.trim();
    }
}