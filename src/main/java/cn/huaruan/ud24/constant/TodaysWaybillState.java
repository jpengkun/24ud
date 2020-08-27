package cn.huaruan.ud24.constant;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 即时达运单状态
 *
 * @author outas
 */
@Getter
public enum TodaysWaybillState {

    /**
     * 预下单
     */
    PRE_ORDER(-1, "预下单"),

    /**
     * 待取件
     */
    WAITING_PICK(1, "待取件"),

    /**
     * 待揽件入库
     */
    WAITING_PACKAGE(2, "待入库"),

    /**
     * 待运输
     */
    WAITING_TRANSPORT(3, "待运输"),

    /**
     * 运输中
     */
    TRANSPORTING(4, "运输中"),

    /**
     * 待出库
     */
    WAITING_DISPATCH(5, "待出库"),

    /**
     * 派送中
     */
    DELIVERING(6, "派送中"),

    /**
     * 已签收
     */
    SIGNED(7, "已签收"),

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

    TodaysWaybillState(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public static TodaysWaybillState getByValue(int value) {
        for (TodaysWaybillState state : values()) {
            if (state.getState() == value) {
                return state;
            }
        }
        return null;
    }


    public static String allToString() {
        List<String> all = new ArrayList<>();
        for (TodaysWaybillState state : values()) {
            all.add(state.toString());
        }
        return all.toString();
    }

    @Override
    public String toString() {
        return state + ":" + desc;
    }
}
