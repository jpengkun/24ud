package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.RoleAuthority;
import cn.huaruan.ud24.query.mapper.RoleAuthorityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleAuthorityDao extends RoleAuthorityMapper {

    int insertRoleAuthorities(List<RoleAuthority> records);

}