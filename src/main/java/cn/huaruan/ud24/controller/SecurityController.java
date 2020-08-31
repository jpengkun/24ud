package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.query.Page;
import cn.huaruan.ud24.query.entity.Authority;
import cn.huaruan.ud24.security.SecurityUser;
import cn.huaruan.ud24.security.WebSecurityConfig;
import cn.huaruan.ud24.service.SecurityService;
import cn.huaruan.ud24.security.AuthorityNode;
import cn.huaruan.ud24.vo.FindRoleParam;
import cn.huaruan.ud24.vo.RoleWithAuthority;
import cn.huaruan.ud24.application.RequestUtils;
import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.OkHttpUtils;
import cn.huaruan.ud24.application.exception.AppRunException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 安全控制器。
 *
 * @author outas
 */
@RestController
@RequestMapping("/security")
@AllArgsConstructor
@Api(tags = "安全权限")
public class SecurityController {

    private static String prefix = "package " +
            WebSecurityConfig.class.getPackage().getName() +
            ";\n\n" +
            "/**\n" +
            " * 权限编码常量类，该类由接口生成。\n" +
            " * @author outas\n" +
            " */\n" +
            "public final class AuthorityCodes {";

    private static String suffix = "\n}";

    private final SecurityService securityService;

    @ApiOperation("获取当前登陆的用户信息")
    @GetMapping("/currentUser")
    public ResultMessage<SecurityUser> getCurrentUser() {
        return new ResultMessage<>(RequestUtils.getCurrentUser());
    }

    @ApiOperation("获取所有权限")
    @GetMapping("/authority")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_MANAGE + "')")
    public ResultMessage<List<Authority>> getAllAuthority() {
        return new ResultMessage<>(securityService.getAllAuthority());
    }

    @ApiOperation("获取所有权限树")
    @GetMapping("/authority/tree")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_MANAGE + "')")
    public ResultMessage<List<AuthorityNode>> getAuthorityTree() {
        return new ResultMessage<>(securityService.getAuthorityTree());
    }

    @ApiOperation("新增权限")
    @PostMapping("/authority")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_ADD + "')")
    public ResultMessage<?> addAuthority(@RequestBody Authority authority) {
        securityService.addAuthority(authority);
        return new ResultMessage<>();
    }

    @ApiOperation("更新权限")
    @PutMapping("/authority")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_UPDATE + "')")
    public ResultMessage<?> updateAuthority(@RequestBody Authority authority) {
        securityService.updateAuthority(authority);
        return new ResultMessage<>();
    }

    @ApiOperation("删除权限")
    @DeleteMapping("/authority/{authorityId}")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_DELETE + "')")
    public ResultMessage<?> deleteAuthority(@PathVariable String authorityId) {
        securityService.deleteAuthority(authorityId);
        return new ResultMessage<>();
    }

    @ApiOperation("导出权限编码常量类")
    @GetMapping("/exportAuthorityCodes")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.AUTHORITY_MANAGE + "')")
    public void exportAuthorityCodes(HttpServletResponse response) {
        StringBuilder content = new StringBuilder(prefix);
        List<Authority> authorities = securityService.getAllAuthority();
        for (Authority authority : authorities) {
            content.append("\n\n    /** ")
                    .append("\n     * ")
                    .append(authority.getName())
                    .append("\n     */ ")
                    .append("\n    public static final String ")
                    .append(authority.getCode()).append(" = \"")
                    .append(authority.getCode()).append("\";");
        }
        content.append(suffix);
        // 导出文件输出流
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.getType());
        try {
            String fileName = OkHttpUtils.encodeUrl("AuthorityCodes.java");
            response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            response.getWriter().print(content.toString());
            response.getWriter().flush();
        } catch (IOException e) {
            throw new AppRunException("导出文件输出流错误！");
        }
    }

    @ApiOperation("分页查找角色带权限")
    @GetMapping("/role")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.ROLE_MANAGE + "')")
    public ResultMessage<Page<RoleWithAuthority>> findRoleWithAuthority(FindRoleParam findRoleParam) {
        return new ResultMessage<>(securityService.findRoleWithAuthority(findRoleParam));
    }

    @ApiOperation("查找所有角色")
    @GetMapping("/role/all")
    public ResultMessage<List<RoleWithAuthority>> findRoleWithAuthority() {
        return new ResultMessage<>(securityService.findRoleWithAuthority());
    }

    @ApiOperation("新增角色及其权限关联")
    @PostMapping("/role")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.ROLE_ADD + "')")
    public ResultMessage<?> addRoleWithAuthority(
            @RequestBody RoleWithAuthority roleWithAuthority) {
        securityService.addRoleWithAuthority(roleWithAuthority);
        return new ResultMessage<>();
    }

    @ApiOperation("更新角色及其权限关联")
    @PutMapping("/role")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.ROLE_UPDATE + "')")
    public ResultMessage<?> updateRoleWithAuthority(
            @RequestBody RoleWithAuthority roleWithAuthority) {
        securityService.updateRoleWithAuthority(roleWithAuthority);
        return new ResultMessage<>();
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/role/{roleId}")
//    @PreAuthorize("hasAuthority('" + AuthorityCodes.ROLE_DELETE + "')")
    public ResultMessage<?> deleteRole(@PathVariable String roleId) {
        securityService.deleteRole(roleId);
        return new ResultMessage<>();
    }

}
