package cn.huaruan.ud24.application.exception;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.constant.ResultStatus;

/**
 * 业务运行时异常对象，方便统一处理
 * @author outas
 */
public class AppRunException extends BaseException{
    public AppRunException() {
        super();
    }

    public AppRunException(String message) {
        super(message);
    }

    public AppRunException(ResultMessage resultMessage) {
        super(resultMessage);
    }

    public AppRunException(ResultStatus status) {
        super(status);
    }

    public AppRunException(ResultStatus status, Object data) {
        super(status, data);
    }

    public AppRunException(Integer code, String message) {
        super(code, message);
    }

    public AppRunException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
