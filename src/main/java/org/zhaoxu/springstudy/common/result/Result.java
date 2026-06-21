package org.zhaoxu.springstudy.common.result;

import lombok.Data;
import org.zhaoxu.springstudy.common.enums.IResultCode;
import org.zhaoxu.springstudy.common.enums.base.BaseResultCode;

import java.util.Date;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private long timestamp;

    public Result() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(BaseResultCode.SUCCESS.getCode());
        result.setMsg(BaseResultCode.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    // 接收所有实现 IResultCode 的枚举（通用+业务枚举都能用）
    public static <T> Result<T> error(IResultCode codeEnum) {
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(codeEnum.getMsg());
        result.setData(null);
        return result;
    }

    public static <T> Result<T> error(IResultCode codeEnum, String msg) {
        Result<T> result = new Result<>();
        result.setCode(codeEnum.getCode());
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
