package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.RoleMapper;
import cn.huaruan.ud24.vo.FindRoleParam;
import cn.huaruan.ud24.vo.RoleWithAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends RoleMapper {

    long countRole(FindRoleParam findRoleParam);

    List<RoleWithAuthority> findRoleWithAuthority(FindRoleParam findRoleParam);

}