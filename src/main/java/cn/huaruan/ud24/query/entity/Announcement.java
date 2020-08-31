/**
 * File Name:Announcement
 * Package Name:com.huaruan.woho.mapper.entity
 * Date:2020-06-02
 * Copyright (c) 2019, http://www.cspos.com All Rights Reserved.
 *
 */
package cn.huaruan.ud24.query.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Table: woho_system_announcement <br/>
 * Description:  <br/>
 * date: 2020-06-02 <br/>
 * 
 * @author generator
 * @version
 * @since JDK 1.8
 */
@SuppressWarnings("serial")
@ApiModel(value="")
public class Announcement extends BaseEntity<String> {
    /**
     * 1-所有用户 2-商家 3-小超 4-区级代理 5-普通用户
     */
    @ApiModelProperty(value ="0-所有用户 1-商家 2-小超 3-区级代理 4-普通用户")
    private Integer type;

    /**
     * 公告标题
     */
    @ApiModelProperty(value ="公告标题")
    private String title;

    /**
     * userId
     */
    private String userId;

    private String fromUserId;

    /**
     * 公告内容
     */
    @ApiModelProperty(value ="公告内容")
    private String context;

    @ApiModelProperty(value ="公告类型 0 文本 1 带地址链接")
    private String contextType;

    @ApiModelProperty
    private Integer pushType;

    /**
     * 1-所有用户 2-商家 3-小超 4-区级代理 5-普通用户
     * @return type 1-所有用户 2-商家 3-小超 4-区级代理 5-普通用户
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1-所有用户 2-商家 3-小超 4-区级代理 5-普通用户
     * @param type 1-所有用户 2-商家 3-小超 4-区级代理 5-普通用户
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 公告标题
     * @return title 公告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 公告标题
     * @param title 公告标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 公告内容
     * @return context 公告内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 公告内容
     * @param context 公告内容
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getContextType() {
        return contextType;
    }

    public void setContextType(String contextType) {
        this.contextType = contextType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getPushType() {
        return pushType;
    }

    public void setPushType(Integer pushType) {
        this.pushType = pushType;
    }
}