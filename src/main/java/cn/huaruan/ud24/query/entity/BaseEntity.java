/**  
 * Project Name:cs-pos-common  
 * File Name:BaseEntity.java  
 * Package com.cspos.common.mapper.common.entity  
 * Copyright (c) 2020, http://www.hm.com All Rights Reserved.  
 *  
*/

package cn.huaruan.ud24.query.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: BaseEntity <br/>
 * Description: 基础Entity.<br/>  
 * date: 2020年3月4日 下午12:43:48 <br/>  
 *  
 * @author haiming.huang  
 *
 * @param <ID>
 */

@ApiModel("基础信息")
public class BaseEntity<ID extends Serializable> extends PageHai {

	private static final long serialVersionUID = -2436840726548371176L;

	@ApiModelProperty("主键")
	protected ID id;

	@ApiModelProperty("创建人ID")
	protected ID createUserId;

	@ApiModelProperty("创建人")
	protected String createUserName;

	@ApiModelProperty("创建时间")
	protected Date createTime;

	@ApiModelProperty("更新人ID")
	protected ID updateUserId;

	@ApiModelProperty("更新人")
	protected String updateUserName;

	@ApiModelProperty("最后更新时间")
	protected Date lastUpdateTime;

	@ApiModelProperty("删除标记 0：未删除 1：已删除")
	protected Integer deleteFlag;

	@ApiModelProperty("版本号")
	protected Integer version;


	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@JsonIgnore
	public ID getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(ID createUserId) {
		this.createUserId = createUserId;
	}

	@JsonIgnore
	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonIgnore
	public ID getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(ID updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonIgnore
	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@JsonIgnore
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


}
