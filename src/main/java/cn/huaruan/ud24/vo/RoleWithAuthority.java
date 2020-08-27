package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.Authority;
import cn.huaruan.ud24.query.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class RoleWithAuthority extends Role {

    List<Authority> authorities;
}
