package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.Authority;
import cn.huaruan.ud24.query.mapper.AuthorityMapper;
import cn.huaruan.ud24.security.AuthorityNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityDao extends AuthorityMapper {

    List<AuthorityNode> getUserAuthorities(String userId);

    List<AuthorityNode> getRoleAuthorities(String roleId);

    List<AuthorityNode> getAuthorityNodes();

    List<Authority> findAuthorityByRoleIdList(List<String> roleIdList);
}