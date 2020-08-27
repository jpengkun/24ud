package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.entity.UserRole;
import cn.huaruan.ud24.query.mapper.UserRoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao extends UserRoleMapper {

    int insertUserRoles(List<UserRole> userRoles);

}