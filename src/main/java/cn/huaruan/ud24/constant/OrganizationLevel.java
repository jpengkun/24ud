package cn.huaruan.ud24.constant;

import lombok.Getter;

/**
 * 即时达运单状态
 *
 * @author outas
 */
@Getter
public enum OrganizationLevel {

    /**
     * 总部
     */
    CENTER(0),

    /**
     * 省
     */
    PROVINCE(1),

    /**
     * 市
     */
    CITY(2),

    /**
     * 区
     */
    DISTRICT(3),

    /**
     * 网点
     */
    SITE(4),

    /**
     * 区域
     */
    REGION(5);


    /**
     * 状态
     */
    private Integer level;

    /**
     * 返回信息
     */

    OrganizationLevel(Integer level) {
        this.level = level;
    }
}
