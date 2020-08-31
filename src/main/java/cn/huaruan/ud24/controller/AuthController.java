package cn.huaruan.ud24.controller;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.JwtUtils;
import cn.huaruan.ud24.application.common.SmsUtils;
import cn.huaruan.ud24.application.exception.BaseException;
import cn.huaruan.ud24.constant.LoginUserType;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.huaruan.ud24.query.entity.TimelyCourier;
import cn.huaruan.ud24.security.LoginRequest;
import cn.huaruan.ud24.security.SecurityUser;
import cn.huaruan.ud24.service.TimelyCourierService;
import cn.huaruan.ud24.vo.SendMsgParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.logging.Logger;

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

    private final TimelyCourierService courierService;


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
        principal.setAuthorization("Bearer " + jwt);
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

    /**
     * 找回密码
     * @param sendMsgParam
     * @return
     * @throws Exception
     */
    @PostMapping("/backPwd")
    @ApiOperation(value = "骑手帐号密码找回")
    public ResultMessage backPwd(@RequestBody SendMsgParam sendMsgParam) throws Exception {
        if (sendMsgParam.getPhone().length()>0&&sendMsgParam.getPhone()!=null&&!"".equals(sendMsgParam.getPhone())){
            TimelyCourier byPhone = courierService.findByPhone(sendMsgParam.getPhone());
            if (byPhone!=null) {
                SendMsgParam sendMsgParam1 = new SendMsgParam();
                sendMsgParam1.setMsgNum(sendMsgParam.getMsgNum());
                sendMsgParam1.setPhone(sendMsgParam.getPhone());
                sendMsgParam1.setHash(sendMsgParam.getHash());
                sendMsgParam1.setTamp(sendMsgParam.getTamp());
                sendMsgParam1.setPassword(sendMsgParam.getPassword());
                SmsUtils.validate(sendMsgParam1);

                byPhone.setPassword(sendMsgParam.getPassword());
                System.out.println("=================888#W###:"+byPhone.getPassword());
                byPhone.setPassword(sendMsgParam.getPassword());
                courierService.updateCourier(byPhone);
                return new ResultMessage(ResultStatus.SUCCESS);
            }else {
                return new ResultMessage(ResultStatus.FAILURE);
            }
        }else {
            return new ResultMessage(ResultStatus.FAILURE);
        }
    }



}
