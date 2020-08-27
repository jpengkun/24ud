package cn.huaruan.ud24.application.exception;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.constant.ResultStatus;

/**
 * 参数异常类
 * @author outas
 */
public class ParamException extends BaseException {

    public ParamException() {
    }

    public ParamException(String message) {
       super(message);
       this.setCode(ResultStatus.PARAM_NOT_MATCH.getCode());
    }

    public ParamException(ResultMessage resultMessage) {
        super(resultMessage);
    }

    public ParamException(ResultStatus status) {
        super(status);
    }

    public ParamException(ResultStatus status, Object data) {
        super(status, data);
    }

    public ParamException(Integer code, String message) {
        super(code, message);
    }

    public ParamException(Integer code, String message, Object data) {
        super(code, message, data);
    }
}
