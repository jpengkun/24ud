package cn.huaruan.ud24.security;

import cn.huaruan.ud24.service.SecurityService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Security 用户服务。
 *
 * @author outas
 */
@Transactional(rollbackFor = Throwable.class)
@Service
public class SecurityUserService implements UserDetailsService {

    private final SecurityService securityService;

    public SecurityUserService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // 获取用户信息
        SecurityUser securityUser = securityService.getSecurityUser(username);
        if (securityUser == null) {
            throw new UsernameNotFoundException("用户名不存在或已删除。");
        }
        return securityUser;
    }

}