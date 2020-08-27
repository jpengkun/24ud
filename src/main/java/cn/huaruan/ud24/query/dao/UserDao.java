package cn.huaruan.ud24.query.dao;

import cn.huaruan.ud24.query.mapper.UserMapper;
import cn.huaruan.ud24.vo.FindUserParam;
import cn.huaruan.ud24.vo.UserWithRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends UserMapper {

    long countUser(FindUserParam findUserParam);

    List<UserWithRole> findUserWithRole(FindUserParam findUserParam);

}