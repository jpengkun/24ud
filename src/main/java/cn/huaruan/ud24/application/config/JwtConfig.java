package cn.huaruan.ud24.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JWT 配置
 * @author outas
 */
@ConfigurationProperties(prefix = "jwt.config")
@Data
public class JwtConfig {
    /**
     * jwt 加密 key，默认值：huaruan.
     */
    private String key = "huaruan";

    /**
     * jwt 过期时间，默认值：1800000 {@code 30 分钟}.
     */
    private Long ttl = 18000000000L;

    /**
     * 开启 记住我 之后 jwt 过期时间，默认值 604800000 {@code 7 天}
     */
    private Long remember = 604800000L;
}
