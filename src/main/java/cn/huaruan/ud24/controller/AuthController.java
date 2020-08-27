package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.JwtUtils;
import cn.huaruan.ud24.application.exception.AppRunException;
import cn.huaruan.ud24.application.exception.BaseException;
import cn.huaruan.ud24.constant.LoginUserType;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.huaruan.ud24.security.LoginRequest;
import cn.huaruan.ud24.security.SecurityUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 权限认证控制器
 *
 * @author outas
 */
@RestController
@RequestMapping
@AllArgsConstructor
@Api(tags = "权限认证")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultMessage login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        StringBuilder username = new StringBuilder(loginRequest.getUsername());

        Integer type = loginRequest.getType();
        if (type.equals(LoginUserType.LG.getType())) {
            username.insert(0, LoginUserType.LG.name());
        } else if (type.equals(LoginUserType.TODAYS.getType())) {
            username.insert(0, LoginUserType.TODAYS.name());
        } else if (type.equals(LoginUserType.TIMELY.getType())) {
            username.insert(0, LoginUserType.TIMELY.name());
        } else if (type.equals(LoginUserType.STATION.getType())) {
            username.insert(0, LoginUserType.STATION.name());
        } else if (type.equals(LoginUserType.VIP.getType())) {
            username.insert(0, LoginUserType.VIP.name());
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        SecurityUser principal = (SecurityUser) authentication.getPrincipal();
        if (principal.getLoginStatus() != null && !principal.getLoginStatus()){
            throw new DisabledException("帐号被禁用！");
        }
        String jwt = jwtUtils.createJWT(loginRequest.getRememberMe(), principal.getUserId(), username.toString());
        response.setHeader("Authorization", "Bearer " + jwt);
        return new ResultMessage<>(authentication.getPrincipal());
    }

    @ApiOperation("登出")
    @PostMapping("/logout")
    public ResultMessage logout(HttpServletRequest request) {
        try {
            // 设置JWT过期
            jwtUtils.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new BaseException(ResultStatus.UNAUTHORIZED);
        }
        return new ResultMessage(ResultStatus.LOGOUT);
    }

}
