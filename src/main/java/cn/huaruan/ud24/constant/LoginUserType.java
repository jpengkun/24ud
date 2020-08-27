package cn.huaruan.ud24.constant;

import lombok.Getter;

/**
 * 登录用户类型
 * @author outas
 */
@Getter
public enum LoginUserType {
    /**
     * 后台
     */
    LG(0),

    /**
     * 当日达
     */
    TODAYS(1),

    /**
     * 即时达
     */
    TIMELY(2),

    /**
     * 把枪
     */
    STATION(3),

    /**
     * 游客
     */
    GUEST(4),
    /**
     * VIP
     */
    VIP(5);


    /**
     * 状态码
     */
    private Integer type;

    /**
     * 返回信息
     */

    LoginUserType(Integer type) {
        this.type = type;
    }

}
