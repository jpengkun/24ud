package cn.huaruan.ud24.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cn.huaruan.ud24.application.common.TreeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Security 用户。
 * 该对象需要缓存和序列化，尽量保持结构稳定。
 *
 * @author outas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityUser implements UserDetails {

    private String userId;

    private String username;

    private String nickname;

    private String password;

    private String orgId;

    private String orgName;

    private Integer level;

    private Integer status;

    private String Authorization;

    @JsonIgnore
    private Boolean loginStatus;
    /**
     * 功能点权限。
     */
    private List<AuthorityNode> authorities;
    private List<AuthorityNode> authorityTree;

    /**
     * 注解中hasRole表达式会调用该方法。
     */
    @Override
    @JsonIgnore
    public List<AuthorityNode> getAuthorities() {
        return authorities;
    }

    public List<AuthorityNode> getAuthorityTree() {
        return authorityTree;
    }

    /**
     * Authority相当于角色。
     */
    public void setAuthorities(List<AuthorityNode> authorities) {
        this.authorities = authorities;
        this.authorityTree = TreeUtils.toTree(authorities,
                ArrayList::new,
                AuthorityNode::getAuthorityId,
                AuthorityNode::getParentId,
                AuthorityNode::getChildren,
                AuthorityNode::setChildren);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object rhs) {
        return rhs instanceof SecurityUser ? this.username.equals(((SecurityUser) rhs).username) : false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }
}
