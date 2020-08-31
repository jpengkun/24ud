package cn.huaruan.ud24.service;

import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.common.UUIDUtil;
import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.constant.LoginUserType;
import cn.huaruan.ud24.query.dao.*;
import cn.huaruan.ud24.query.entity.*;
import cn.huaruan.ud24.security.SecurityUser;
import cn.huaruan.ud24.security.AuthorityNode;
import cn.huaruan.ud24.vo.FindRoleParam;
import cn.huaruan.ud24.vo.OrgWithRegion;
import cn.huaruan.ud24.vo.RoleWithAuthority;
import cn.huaruan.ud24.application.common.TreeUtils;
import cn.huaruan.ud24.application.query.QueryUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 安全服务。
 **/
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Throwable.class)
public class SecurityService {

    private final UserDao userDao;

    private final TodaysCourierDao todaysCourierDao;

    private final TimelyCourierDao timelyCourierDao;

    private final StationUserDao stationUserDao;

    private final VipUserDao vipUserDao;

    private final OrganizationDao organizationDao;

    private final AuthorityDao authorityDao;

    private final RoleAuthorityDao roleAuthorityDao;

    private final RoleDao roleDao;

    private final BCryptPasswordEncoder passwordEncoder;

    private final String DEFAULT_PASSWORD = "123456";

    private static final Pattern CODE_PATTERN = Pattern.compile("[a-zA-Z]|([a-zA-Z][a-zA-Z0-9_]*[a-zA-Z0-9])");

    /**
     * 根据用户名用户
     *
     * @param username 用户名
     * @return
     */
    public SecurityUser getSecurityUser(String username) {
        AppAsserts.hasText(username, "用户名不能为空！");

        SecurityUser securityUser = null;
        if (username.startsWith(LoginUserType.LG.name())) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andUsernameEqualTo(username.replace(LoginUserType.LG.name(), ""));
            List<User> users = userDao.selectByExample(userExample);
            if (QueryUtils.getFirstOne(users) == null) {
                return null;
            }
            User user = QueryUtils.getFirstOne(users);
            // 获取用户功能权限
            securityUser = QueryUtils.copyProperties(user, new SecurityUser());
            OrgWithRegion organization = organizationDao.findById(user.getOrgId());
            if (organization != null) {
                securityUser.setLevel(organization.getLevel());
            }
            securityUser.setAuthorities(getUserAuthorities(securityUser.getUserId()));
            securityUser.setLoginStatus(user.getStatus());
        } else if (username.startsWith(LoginUserType.TODAYS.name())) {
            TodaysCourierExample example = new TodaysCourierExample();
            example.createCriteria().andPhoneEqualTo(username.replace(LoginUserType.TODAYS.name(), ""));
            List<TodaysCourier> todaysCouriers = todaysCourierDao.selectByExample(example);
            TodaysCourier todaysCourier = QueryUtils.getFirstOne(todaysCouriers);

            if (todaysCourier == null) {
                return null;
            }
            securityUser = new SecurityUser();
            securityUser.setUserId(todaysCourier.getId());
            securityUser.setNickname(todaysCourier.getName());
            securityUser.setUsername(todaysCourier.getPhone());
            securityUser.setOrgId(todaysCourier.getOid());
            securityUser.setPassword(todaysCourier.getPassword());
            securityUser.setStatus(todaysCourier.getState());
            securityUser.setLoginStatus(todaysCourier.getState() != 0);
        } else if (username.startsWith(LoginUserType.TIMELY.name())) {
            TimelyCourierExample example = new TimelyCourierExample();
            example.createCriteria().andPhoneEqualTo(username.replace(LoginUserType.TIMELY.name(), ""));
            List<TimelyCourier> timelyCouriers = timelyCourierDao.selectByExample(example);
            TimelyCourier timelyCourier = QueryUtils.getFirstOne(timelyCouriers);

            if (timelyCourier == null) {
                return null;
            }
            securityUser = new SecurityUser();
            securityUser.setUserId(timelyCourier.getId());
            securityUser.setNickname(timelyCourier.getName());
            securityUser.setUsername(timelyCourier.getPhone());
            securityUser.setPassword(timelyCourier.getPassword());
            securityUser.setStatus(timelyCourier.getState());
            securityUser.setLevel(timelyCourier.getDeposit().toBigInteger().intValue());
            securityUser.setLoginStatus(timelyCourier.getState() != 0);
        } else if (username.startsWith(LoginUserType.STATION.name())) {
            StationUserExample example = new StationUserExample();
            example.createCriteria().andPhoneEqualTo(username.replace(LoginUserType.STATION.name(), ""));
            List<StationUser> stationUsers = stationUserDao.selectByExample(example);
            StationUser stationUser = QueryUtils.getFirstOne(stationUsers);

            if (stationUser == null) {
                return null;
            }

            Organization organization = organizationDao.selectByPrimaryKey(stationUser.getOid());
            securityUser = new SecurityUser();
            securityUser.setUserId(stationUser.getId());
            securityUser.setOrgId(organization.getId());
            securityUser.setOrgName(organization.getName());
            securityUser.setLevel(organization.getLevel());
            securityUser.setNickname(stationUser.getUserName());
            securityUser.setUsername(stationUser.getPhone());
            securityUser.setPassword(stationUser.getPassword());
        } else if (username.startsWith(LoginUserType.GUEST.name())) {
            securityUser = new SecurityUser();
            securityUser.setUsername(LoginUserType.GUEST.toString());
            securityUser.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        } else if (username.startsWith(LoginUserType.VIP.name())) {
            VipUserExample vipUserExample = new VipUserExample();
            vipUserExample.createCriteria().andUserNameEqualTo(username.replace(LoginUserType.VIP.name(), ""));
            List<VipUser> vipUsers = vipUserDao.selectByExample(vipUserExample);
            VipUser vipUser = QueryUtils.getFirstOne(vipUsers);
            if (vipUser == null) {
                return null;
            }
            securityUser = new SecurityUser();
            securityUser.setUserId(vipUser.getVUserId());
            securityUser.setUsername(vipUser.getUserName());
            securityUser.setPassword(vipUser.getPassword());
            securityUser.setLevel(vipUser.getType());
            securityUser.setLoginStatus(vipUser.getState() != 0);
        }
        return securityUser;
    }

    public List<Authority> getAllAuthority() {
        return authorityDao.selectByExample(new AuthorityExample());
    }

    /**
     * 新增权限
     *
     * @param authority 权限对象
     */
    public void addAuthority(Authority authority) {
        AppAsserts.notNull(authority, "权限信息不能为空！");
        AppAsserts.hasText(authority.getName(), "权限名称不能为空！");
        AppAsserts.matchPattern(authority.getCode(), CODE_PATTERN,
                "权限编码应由字母、数字和下划线组成，以字母开头、字母或数字结束！");
        AppAsserts.hasText(authority.getType(), "权限类型不能为空！");

        AuthorityExample exampleName = new AuthorityExample();
        exampleName.createCriteria().andNameEqualTo(authority.getName());
        AppAsserts.yes(authorityDao.countByExample(exampleName) < 1,
                "权限名称 " + authority.getName() + " 已存在！");

        AuthorityExample exampleCode = new AuthorityExample();
        exampleCode.createCriteria().andCodeEqualTo(authority.getCode());
        AppAsserts.yes(authorityDao.countByExample(exampleCode) < 1,
                "权限编码 " + authority.getCode() + " 已存在！");

        authority.setAuthorityId(UUIDUtil.get());
        authority.setCode(authority.getCode().toUpperCase());
        authority.setCreateTime(new Date());
        authorityDao.insertSelective(authority);
    }

    /**
     * 根据id更新权限
     *
     * @param authority 权限对象
     */
    public void updateAuthority(Authority authority) {
        AppAsserts.notNull(authority, "权限信息不能为空！");
        AppAsserts.notNull(authority.getAuthorityId(), "权限id不能为空！");
        AppAsserts.hasText(authority.getName(), "权限名称不能为空！");
        AppAsserts.matchPattern(authority.getCode(), CODE_PATTERN,
                "权限编码应由字母、数字和下划线组成，以字母开头、字母或数字结束！");
        AppAsserts.hasText(authority.getType(), "权限类型不能为空！");

        AuthorityExample exampleName = new AuthorityExample();
        exampleName.createCriteria().andNameEqualTo(authority.getName())
                .andAuthorityIdNotEqualTo(authority.getAuthorityId());
        AppAsserts.yes(authorityDao.countByExample(exampleName) < 1,
                "权限名称 " + authority.getName() + " 已存在！");

        AuthorityExample exampleCode = new AuthorityExample();
        exampleCode.createCriteria().andCodeEqualTo(authority.getCode())
                .andAuthorityIdNotEqualTo(authority.getAuthorityId());
        AppAsserts.yes(authorityDao.countByExample(exampleCode) < 1,
                "权限编码 " + authority.getCode() + " 已存在！");

        authority.setCode(authority.getCode().toUpperCase());
        authorityDao.updateByPrimaryKeySelective(authority);
    }

    /**
     * 根据权限id删除权限
     *
     * @param authorityId 要删除的权限id
     */
    public void deleteAuthority(String authorityId) {
        AppAsserts.notNull(authorityId, "权限id不能为空！");

        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andParentIdEqualTo(authorityId);
        AppAsserts.yes(authorityDao.countByExample(authorityExample) < 1,
                "请先删除所有子权限！");

        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        roleAuthorityExample.createCriteria().andAuthorityIdEqualTo(authorityId);
        AppAsserts.yes(roleAuthorityDao.countByExample(roleAuthorityExample) < 1,
                "该权限已有角色正在使用！");

        authorityDao.deleteByPrimaryKey(authorityId);
    }

    /**
     * 获取所有的权限
     *
     * @return 树状权限列表
     */
    public List<AuthorityNode> getAuthorityTree() {
        return TreeUtils.toTree(authorityDao.getAuthorityNodes(),
                ArrayList::new,
                AuthorityNode::getAuthorityId,
                AuthorityNode::getParentId,
                AuthorityNode::getChildren,
                AuthorityNode::setChildren);
    }

    /**
     * 根据用户id获取该用户的权限
     *
     * @param userId 用户id
     * @return 该用户的所有权限列表
     */
    public List<AuthorityNode> getUserAuthorities(String userId) {
        AppAsserts.notNull(userId, "用户id不能为空！");
        return authorityDao.getUserAuthorities(userId);
    }

    /**
     * 根据角色id获取该角色的权限
     *
     * @param roleId 角色id
     * @return 该角色的权限列表
     */
    public List<AuthorityNode> getRoleAuthorities(String roleId) {
        AppAsserts.notNull(roleId, "角色id不能为空！");
        return authorityDao.getRoleAuthorities(roleId);
    }

    /**
     * 获取所有的角色列表
     *
     * @return 所有的角色列表
     */
    public List<Role> getAllRoles() {
        return roleDao.selectByExample(new RoleExample());
    }

    /**
     * 根据条件分页查询角色
     *
     * @param findRoleParam 查询参数
     * @return 带有权限的角色列表
     */
    public cn.huaruan.ud24.application.query.Page<RoleWithAuthority> findRoleWithAuthority(FindRoleParam findRoleParam) {
        return new Page<>(roleDao.countRole(findRoleParam),
                roleDao.findRoleWithAuthority(findRoleParam));
    }

    /**
     * 查询角色所有角色
     *
     * @return 角色列表
     */
    public List<RoleWithAuthority> findRoleWithAuthority() {
        return roleDao.findRoleWithAuthority(null);
    }

    /**
     * 新增一个带有权限的角色
     *
     * @param roleWithAuthority 角色权限对象
     */
    public void addRoleWithAuthority(RoleWithAuthority roleWithAuthority) {
        AppAsserts.notNull(roleWithAuthority, "角色对象不能为空。");
        AppAsserts.notNull(roleWithAuthority.getName(), "角色名不能为空。");

        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo(roleWithAuthority.getName());
        AppAsserts.yes(roleDao.countByExample(roleExample) < 1,
                "角色名已被使用。");

        // 使用自定义VO新增角色
        roleWithAuthority.setRoleId(UUIDUtil.get());
        roleWithAuthority.setCreateTime(new Date());
        roleDao.insertSelective(roleWithAuthority);

        // 批量建立新的角色权限关系
        addRoleAuthorities(roleWithAuthority);
    }

    /**
     * 根据角色id更新该角色的权限
     *
     * @param roleWithAuthority 角色权限对象
     */
    public void updateRoleWithAuthority(RoleWithAuthority roleWithAuthority) {
        AppAsserts.notNull(roleWithAuthority, "角色对象不能为空。");
        AppAsserts.notNull(roleWithAuthority.getRoleId(), "角色id不能为空。");
        AppAsserts.notNull(roleWithAuthority.getName(), "角色名不能为空。");

        // 名称存在并且不是自己
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo(roleWithAuthority.getName())
                .andRoleIdNotEqualTo(roleWithAuthority.getRoleId());
        AppAsserts.yes(roleDao.countByExample(roleExample) < 1,
                "角色名已被使用。");

        // 使用自定义VO更新角色
        roleDao.updateByPrimaryKeySelective(roleWithAuthority);

        // 批量建立新的角色权限关系
        addRoleAuthorities(roleWithAuthority);
    }

    /**
     * 根据角色id删除角色
     *
     * @param roleId 要删除的角色id
     */
    public void deleteRole(String roleId) {
        AppAsserts.notNull(roleId, "角色id不能为空。");

        // 清空角色权限关系
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        roleAuthorityDao.deleteByExample(roleAuthorityExample);

        roleDao.deleteByPrimaryKey(roleId);
    }

    /**
     * 给角色添加权限
     *
     * @param roleWithAuthority 角色权限对象
     */
    private void addRoleAuthorities(RoleWithAuthority roleWithAuthority) {
        List<Authority> authorities = roleWithAuthority.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {

            //清空该角色的权限
            RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
            roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleWithAuthority.getRoleId());
            roleAuthorityDao.deleteByExample(roleAuthorityExample);

            List<RoleAuthority> roleAuthorities = new ArrayList<>(authorities.size());
            for (Authority authority : roleWithAuthority.getAuthorities()) {
                RoleAuthority roleAuthority = new RoleAuthority();
                AppAsserts.notNull(authority.getAuthorityId(), "权限id不能为空。");
                roleAuthority.setAuthorityId(authority.getAuthorityId());
                roleAuthority.setRoleId(roleWithAuthority.getRoleId());
                roleAuthority.setCreateTime(new Date());
                roleAuthorities.add(roleAuthority);
            }
            roleAuthorityDao.insertRoleAuthorities(roleAuthorities);
        }
    }
}
