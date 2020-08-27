package cn.huaruan.ud24.vo;

import cn.huaruan.ud24.query.entity.Role;
import cn.huaruan.ud24.query.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author outas
 */
@Data
public class UserWithRole extends User {

    private String orgName;

    private List<Role> roles;

}