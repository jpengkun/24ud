package cn.huaruan.ud24.security;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.common.JwtUtils;
import cn.huaruan.ud24.application.common.ResponseUtil;
import cn.huaruan.ud24.application.config.CustomConfig;
import cn.huaruan.ud24.constant.ResultStatus;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


/**
 * Spring Security 全局配置。
 *
 * @author outas
 */
@Configuration
@Component
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(CustomConfig.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityUserService securityUserService;

    private final JwtUtils jwtUtils;

    private final CustomConfig customConfig;

    public WebSecurityConfig(SecurityUserService securityUserService, JwtUtils jwtUtils, CustomConfig customConfig) {
        this.securityUserService = securityUserService;
        this.jwtUtils = jwtUtils;
        this.customConfig = customConfig;
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return securityUserService;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityUserService);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {

        // 允许跨域访问
        security.cors()
                .and()
                .csrf().disable().headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                // 所有请求都需要验证
                .anyRequest()
                .authenticated()
//                .permitAll()

                .and()
                // 登录行为由自己实现
                .formLogin().disable()
                // 登出行为由自己实现
                .logout().disable()

                // 未登录的请求处理
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint())

                // Session管理
                .and()
                .sessionManagement()
                // 因为使用了JWT，所以这里不管理Session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // 异常处理
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler());

        // 添加自定义 JWT 过滤器
        security.addFilterBefore(JwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    private AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, exception) -> ResponseUtil.renderJson(response, new ResultMessage(ResultStatus.UNAUTHORIZED));
    }


    private JwtAuthenticationFilter JwtAuthenticationFilterBean() {
        return new JwtAuthenticationFilter(securityUserService, jwtUtils, customConfig);
    }

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) ->
                ResponseUtil.renderJson(response,
                        new ResultMessage(ResultStatus.ACCESS_DENIED));
    }

    /**
     * 放行所有不需要登录就可以访问的请求，参见 AuthController
     * 也可以在 {@link #configure(HttpSecurity)} 中配置
     * {@code http.authorizeRequests().antMatchers("/api/auth/**").permitAll()}
     */
    @Override
    public void configure(WebSecurity security) {
        WebSecurity and = security.ignoring().and();

        // 忽略 GET
        customConfig.getIgnores().getGet().forEach(url -> and.ignoring().antMatchers(HttpMethod.GET, url));

        // 忽略 POST
        customConfig.getIgnores().getPost().forEach(url -> and.ignoring().antMatchers(HttpMethod.POST, url));

        // 忽略 DELETE
        customConfig.getIgnores().getDelete().forEach(url -> and.ignoring().antMatchers(HttpMethod.DELETE, url));

        // 忽略 PUT
        customConfig.getIgnores().getPut().forEach(url -> and.ignoring().antMatchers(HttpMethod.PUT, url));

        // 忽略 HEAD
        customConfig.getIgnores().getHead().forEach(url -> and.ignoring().antMatchers(HttpMethod.HEAD, url));

        // 忽略 PATCH
        customConfig.getIgnores().getPatch().forEach(url -> and.ignoring().antMatchers(HttpMethod.PATCH, url));

        // 忽略 OPTIONS
        customConfig.getIgnores().getOptions().forEach(url -> and.ignoring().antMatchers(HttpMethod.OPTIONS, url));

        // 忽略 TRACE
        customConfig.getIgnores().getTrace().forEach(url -> and.ignoring().antMatchers(HttpMethod.TRACE, url));

        // 按照请求格式忽略
        customConfig.getIgnores().getPattern().forEach(url -> and.ignoring().antMatchers(url));

    }
}