package cn.huaruan.ud24.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Spring Security中的Authority或Role。
 * 该对象需要缓存和序列化，尽量保持结构稳定。
 *
 * @author outas
 */
@Data
public class AuthorityNode implements GrantedAuthority {

    private String authorityId;

    private String parentId;

    private String name;

    private String code;

    private String type;

    private List<AuthorityNode> children;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return code;
    }

}
