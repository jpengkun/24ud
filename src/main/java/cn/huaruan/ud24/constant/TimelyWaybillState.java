package cn.huaruan.ud24.constant;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 即时达运单状态
 *
 * @author outas
 */
@Getter
public enum TimelyWaybillState {

    /**
     * 待接单
     */
    WAITING_ORDER(1, "待接单"),

    /**
     * 待取件
     */
    WAITING_PICK(2, "待取件"),

    /**
     * 已取件
     */
    PICKED(3, "已取件"),

    /**
     * 派送中
     */
    DELIVERING(4, "派送中"),

    /**
     * 派送中
     */
    WAITING_SIGN(5, "待签收"),

    /**
     * 已签收
     */
    SIGNED(6, "已签收"),

    /**
     * 转单
     */
    NEGOTIATION(7, "转单"),

    /**
     * 已取消
     */
    CANCEL(10, "已取消"),

    /**
     * 异常件
     */
    ABNORMAL(99, "异常件");


    /**
     * 状态
     */
    private Integer state;

    /**
     * 描述
     */
    private String desc;

    /**
     * 返回信息
     */

    TimelyWaybillState(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public static TimelyWaybillState getByValue(int value) {
        for (TimelyWaybillState state : values()) {
            if (state.getState() == value) {
                return state;
            }
        }
        return null;
    }

    public static String allToString() {
        List<String> all = new ArrayList<>();
        for (TimelyWaybillState state : values()) {
            all.add(state.toString());
        }
        return all.toString();
    }

    @Override
    public String toString() {
        return state + ":" + desc;
    }
}
