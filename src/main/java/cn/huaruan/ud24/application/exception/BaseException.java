package cn.huaruan.ud24.application.exception;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.constant.ResultStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务运行时异常对象，方便统一处理，支持链式调用。
 * @author outas
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;
    private Object data;

    public BaseException() {
    }

    public BaseException(String message) {
        this.message = message;
    }

    public BaseException(ResultMessage resultMessage) {
        this(resultMessage.getMessage());
        this.code = resultMessage.getCode();
        this.data = resultMessage.getData();
    }

    public BaseException(ResultStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(ResultStatus status, Object data) {
        this(status);
        this.data = data;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Object data) {
        this(code, message);
        this.data = data;
    }
}