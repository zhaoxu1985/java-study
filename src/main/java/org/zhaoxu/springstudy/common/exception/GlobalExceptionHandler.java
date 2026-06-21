package org.zhaoxu.springstudy.common.exception;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.zhaoxu.springstudy.common.enums.base.BaseResultCode;
import org.zhaoxu.springstudy.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 参数校验失败（@Valid）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<Void> handleValid(MethodArgumentNotValidException e) {
        String msg = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return Result.error(BaseResultCode.PARAM_VALID_ERROR, msg);
    }

    // 表单参数绑定失败
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<Void> handleBind(BindException e) {
        String msg = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return Result.error(BaseResultCode.BIND_PARAM_ERROR, msg);
    }

    // 请求体格式错误
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<Void> handleBody() {
        return Result.error(BaseResultCode.REQUEST_BODY_ERROR);
    }

    // 业务异常
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<Void> handleBusiness(BusinessException e) {
        return Result.error(e.getCodeEnum(), e.getMessage());
    }

    // 1. 处理 404 接口不存在
    @ExceptionHandler({NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class, NoResourceFoundException.class})
    @ResponseStatus(HttpStatus.OK)
    public Result<Void>  handle404() {
        return Result.error(BaseResultCode.NOT_FOUND_ERROR);
    }

    // 系统未知异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result<Void> handleAll(Exception e) {
        e.printStackTrace();
        return Result.error(BaseResultCode.SERVER_ERROR);
    }
}