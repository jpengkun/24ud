package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Role;
import cn.huaruan.ud24.query.entity.User;
import cn.huaruan.ud24.security.AuthorityCodes;
import cn.huaruan.ud24.service.SecurityService;
import cn.huaruan.ud24.service.UserService;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.vo.FindUserParam;
import cn.huaruan.ud24.vo.UserWithRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器。
 *
 * @author outas*/
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    private final SecurityService securityService;


    @ApiOperation("根据ID获取用户")
    @GetMapping("/{userId}")
    public ResultMessage<User> getUser(@PathVariable String userId) {
        return new ResultMessage<>(userService.getUserById(userId));
    }

    @ApiOperation("分页查找用户")
    @GetMapping
    @PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<Page<UserWithRole>> findUserWithRole(FindUserParam findUserParam) {
        return new ResultMessage<>(userService.findUserWithRole(findUserParam));
    }

    @ApiOperation("用户管理查找角色")
    @GetMapping("/roles")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.USER_MANAGE + "')")
    public ResultMessage<List<Role>> getAllRoles() {
        return new ResultMessage<>(securityService.getAllRoles());
    }

    @ApiOperation("添加用户并返回ID")
    @PostMapping
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.USER_ADD + "')")
    public ResultMessage addUserWithRole(@RequestBody UserWithRole userWithRole) {
        return new ResultMessage<>(userService.addUserWithRole(userWithRole));
    }

    @ApiOperation("更新用户")
    @PutMapping
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.USER_UPDATE + "')")
    public ResultMessage updateUserWithRole(@RequestBody UserWithRole userWithRole) {
        userService.updateUserWithRole(userWithRole);
        return new ResultMessage();
    }

    @ApiOperation("根据ID删除用户")
    @DeleteMapping("/{userId}")
    public ResultMessage deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ResultMessage();
    }

    @ApiOperation("修改自己的帐号信息")
    @PostMapping("/self")
    public ResultMessage updateUser(@RequestBody User user) {
        userService.update(user);
        return new ResultMessage();
    }

    @ApiOperation("修改用户状态")
    @PutMapping("/changeStatus")
    public ResultMessage changeStatus(@RequestBody User user) {
        userService.changeStatus(user.getUserId(),user.getOperateOrgId());
        return new ResultMessage();
    }

}
