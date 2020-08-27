package cn.huaruan.ud24.application.common;

import java.util.UUID;

/**
 * 字符串工具辅助类
 * @author outas
 **/
public class UUIDUtil {
    /**
     * @throws
     * @Title: getUUID
     * @Description: 获取随机UUID字符串
     * @param: @return
     * @return: String
     */
    public static String get() {
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        return str;
    }


}