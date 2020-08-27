package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.EntityUtils;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.query.dao.*;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.application.query.QueryUtils;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.vo.FindUserParam;
import cn.huaruan.ud24.vo.OrgWithRegion;
import cn.huaruan.ud24.vo.UserWithRole;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务
 *
 * @author outas
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class UserService {

    private final UserDao userDao;

    private final UserRoleDao userRoleDao;

    private final OrganizationDao organizationDao;

    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 添加带角色的用户
     *
     * @param userWithRole 带有角色的用户
     * @return
     */
    public String addUserWithRole(UserWithRole userWithRole) {
        AppAsserts.notNull(userWithRole, "用户不能为空！");
        AppAsserts.hasText(userWithRole.getUsername(), "用户名不能为空！");
        AppAsserts.maxLength(userWithRole.getUsername(), 20, "用户名长度不能大于20位！");
        AppAsserts.minLength(userWithRole.getUsername(), 5, "用户名长度不能少于5位！");
        AppAsserts.hasText(userWithRole.getNickname(), "昵称不能为空！");
        AppAsserts.hasText(userWithRole.getPassword(), "密码不能为空！");

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userWithRole.getUsername());
        AppAsserts.yes(userDao.countByExample(userExample) < 1,
                "用户名已被使用！");

        // 给密码加密
        String encodedPassword = passwordEncoder.encode(userWithRole.getPassword().trim());
        userWithRole.setPassword(encodedPassword);
        userWithRole.setUserId(UUIDUtil.get());
        userWithRole.setCreateTime(new Date());
        userWithRole.setStatus(true);

        userDao.insertSelective(userWithRole);
        // 给用户添加角色
        addUserCustomRoles(userWithRole);

        return userWithRole.getUserId();
    }

    /**
     * 给用户添加角色
     *
     * @param userWithRole 带有角色的用户
     */
    private void addUserCustomRoles(UserWithRole userWithRole) {
        List<Role> roles = userWithRole.getRoles();
        if (roles != null && !roles.isEmpty()) {
            // 清空该用户的角色列表
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(userWithRole.getUserId());
            userRoleDao.deleteByExample(userRoleExample);

            List<UserRole> userRoles = new ArrayList<>(roles.size());
            // 遍历传入的角色将其添加到用户-角色关联表
            for (Role role : roles) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userWithRole.getUserId());
                userRole.setRoleId(role.getRoleId());
                userRole.setCreateTime(new Date());
                userRoles.add(userRole);
            }
            userRoleDao.insertUserRoles(userRoles);
        }
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param userId 要查询的用户id
     * @return 用户对象
     */
    @Cacheable(cacheNames = "UserCache", key = "#userId", unless = "#result==null")
    public User getUserById(String userId) {
        AppAsserts.notNull(userId, "用户id不能为空！");
        return userDao.selectByPrimaryKey(userId);
    }

    /**
     * 根据id更新用户和角色信息
     *
     * @param userWithRole 带有角色的用户
     * @return 更新成功的条数
     */
    @CacheEvict(cacheNames = "UserCache", key = "#userWithRole.userId")
    public long updateUserWithRole(UserWithRole userWithRole) {
        AppAsserts.notNull(userWithRole, "用户不能为空！");
        AppAsserts.notNull(userWithRole.getUserId(), "用户id不能为空！");
        AppAsserts.maxLength(userWithRole.getUsername(), 0, "用户名不可修改！");

        if (StringUtils.hasText(userWithRole.getPassword())) {
            // 给密码加密
            String encodedPassword = passwordEncoder.encode(userWithRole.getPassword().trim());
            userWithRole.setPassword(encodedPassword);
        }

        // 更新用户的角色列表
        addUserCustomRoles(userWithRole);

        // 更新用户
        if (EntityUtils.needToUpdate(userWithRole, UserWithRole.class)) {
            return userDao.updateByPrimaryKeySelective(userWithRole);
        }
        return 0;
    }

    /**
     * 根据条件分页查询所有用户
     *
     * @param findUserParam 查询条件
     * @return 一页带有角色的用户
     */
    public Page<UserWithRole> findUserWithRole(FindUserParam findUserParam) {
        findUserParam.setUsername(QueryUtils.likeContains(findUserParam.getUsername()));
        findUserParam.setNickname(QueryUtils.likeContains(findUserParam.getNickname()));
        return new Page<>(userDao.countUser(findUserParam),
                userDao.findUserWithRole(findUserParam));
    }

    /**
     * 根据用户id删除用户
     *
     * @param userId 要删除的用户id
     * @return 删除成功的条数
     */
    @CacheEvict(cacheNames = "UserCache", key = "#userId")
    public long deleteUser(String userId) {
        AppAsserts.notNull(userId, "用户id不能为空！");
        return userDao.deleteByPrimaryKey(userId);
    }

    public long update(User user) {
        AppAsserts.hasText(user.getUserId(), "用户id不能为空！");
        AppAsserts.maxLength(user.getUsername(), 0, "用户名不可修改！");


        if (StringUtils.hasText(user.getPassword())) {
            // 给密码加密
            String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
            user.setPassword(encodedPassword);
        }
        return userDao.updateByPrimaryKeySelective(user);
    }

    public void changeStatus(String userId, String operateOrgId) {
        User user = userDao.selectByPrimaryKey(userId);
        AppAsserts.notNull(user, "用户不存在！");

        AppAsserts.hasText(operateOrgId, "操作网点id不能为空！");
        // 如果不是第一次被禁用
        if (StringUtils.hasText(user.getOperateOrgId()) && !user.getStatus()) {
            List<OrgWithRegion> parent = organizationDao.findParentById(user.getOperateOrgId());
            if (parent != null && !parent.isEmpty()) {
                List<String> ids = parent.stream().map(Organization::getId).collect(Collectors.toList());
                AppAsserts.yes(ids.contains(operateOrgId),
                        "该用户：已被更高权限的管理员禁用/不属于你的管理范围，你无法进行此操作！");
            }
        }
        user.setStatus(!user.getStatus());
        user.setOperateOrgId(operateOrgId);
        userDao.updateByPrimaryKey(user);
    }
}
