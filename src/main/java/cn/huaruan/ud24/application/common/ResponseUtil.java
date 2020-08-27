package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.application.ResultMessage;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Response 通用工具类
 * @author outas
 */
public class ResponseUtil {

    /**
     * 往 response 写出 json
     * @param response
     * @param resultMessage
     */
    public static void renderJson(HttpServletResponse response, ResultMessage resultMessage) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter().write(JacksonUtils.toJson(resultMessage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
