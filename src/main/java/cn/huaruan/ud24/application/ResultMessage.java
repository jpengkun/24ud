package cn.huaruan.ud24.application;

import cn.huaruan.ud24.application.exception.BaseException;
import cn.huaruan.ud24.constant.ResultStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回值的格式，方便封装处理，支持链式调用。
 * Exception可自动转换成Result格式返回。
 *
 * @author outas
 */
@ApiModel("结果对象")
@Data
public class ResultMessage<E> {

    @ApiModelProperty("结果编码：200为成功")
    private int code = 200;

    @ApiModelProperty("是否成功")
    private boolean success = true;

    @ApiModelProperty("调用方可读的消息")
    private String message = "操作成功！";

    @ApiModelProperty("结果数据或异常调试信息")
    private Object data;

    @ApiModelProperty("用户手机号")
    private String phone;

    /**
     * 默认构造为成功，因为失败还可以用异常。
     */
    public ResultMessage() {
    }

    /**
     * 默认构造为成功并设置数据。
     */
    public ResultMessage(E data) {
        this.data = data;
    }

    /**
     * 默认构造为成功并设置数据。
     */
    public ResultMessage(E data,String phone) {
        this.data = data;
        this.phone = phone;
    }

    public ResultMessage(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        if (this.code >= ResultStatus.BAD_REQUEST.getCode()) {
            this.success = false;
        }
    }

    public ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public <T extends BaseException> ResultMessage exception(T t) {
        if (t.getCode() != null) {
            this.code = t.getCode();
        }
        this.message = t.getMessage();
        this.data = t.getData();
        this.success = false;
        return this;
    }

    public ResultMessage<E> success() {
        this.success = true;
        return this;
    }

    public ResultMessage<E> success(String message) {
        this.message = message;
        this.success = true;
        return this;
    }

    public ResultMessage<E> failure() {
        this.success = false;
        return this;
    }

    public ResultMessage<E> failure(String message) {
        this.message = message;
        this.success = false;
        return this;
    }

    public ResultMessage<E> data(E data) {
        this.data = data;
        return this;
    }

    public ResultMessage<E> code(int code) {
        this.code = code;
        return this;
    }


    public ResultMessage<E> status(ResultStatus status) {
        this.code = status.getCode();
        this.message = status.getMessage();
        if (this.code >= ResultStatus.BAD_REQUEST.getCode()) {
            this.success = false;
        }
        return this;
    }


    public ResultMessage<E> message(String message) {
        this.message = message;
        return this;
    }

}
