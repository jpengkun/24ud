package cn.huaruan.ud24.application.config;

import cn.huaruan.ud24.application.ResultMessage;
import cn.huaruan.ud24.application.exception.BaseException;
import cn.huaruan.ud24.application.exception.ExceptionUtils;
import cn.huaruan.ud24.constant.ResultStatus;
import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import org.springframework.security.access.AccessDeniedException;
/**
 * 全局异常捕获
 * @author outas
 */
@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {

    /**
     * RequestBody返回json
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMessage resolveException(Exception e) {
        if (e instanceof NoHandlerFoundException) {
            return new ResultMessage<>(ResultStatus.REQUEST_NOT_FOUND);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            return new ResultMessage<>(ResultStatus.HTTP_BAD_METHOD);
        } else if (e instanceof MethodArgumentNotValidException) {
            return new ResultMessage<>(ResultStatus.BAD_REQUEST.getCode(), ((MethodArgumentNotValidException) e).getBindingResult()
                    .getAllErrors()
                    .get(0)
                    .getDefaultMessage()).failure();
        } else if (e instanceof ConstraintViolationException) {
            return new ResultMessage<>(ResultStatus.BAD_REQUEST.getCode(), CollUtil.getFirst(((ConstraintViolationException) e).getConstraintViolations())
                    .getMessage()).failure();
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            return new ResultMessage<>(ResultStatus.PARAM_NOT_MATCH);
        } else if (e instanceof HttpMessageNotReadableException) {
            return new ResultMessage<>(ResultStatus.BAD_REQUEST).data(ExceptionUtils.getCauseTrace(e));
        } else if (e instanceof BadCredentialsException) {
            return new ResultMessage<>(ResultStatus.USERNAME_PASSWORD_ERROR);
        } else if (e instanceof DisabledException) {
            return new ResultMessage<>(ResultStatus.USER_DISABLED);
        } else if (e instanceof BaseException) {
            return new ResultMessage<>().exception((BaseException) e);
        }else if (e instanceof AccessDeniedException){
            return new ResultMessage<>(ResultStatus.ACCESS_DENIED);
        }
        return new ResultMessage<>(ResultStatus.ERROR).data(ExceptionUtils.getCauseTrace(e));
    }

}