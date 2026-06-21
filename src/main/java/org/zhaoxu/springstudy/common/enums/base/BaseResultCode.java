package org.zhaoxu.springstudy.common.enums.base;

import lombok.Getter;
import org.zhaoxu.springstudy.common.enums.IResultCode;

@Getter
public enum BaseResultCode implements IResultCode {
    // 成功
    SUCCESS(200, "操作成功"),

    // ========== 通用参数错误 40000-40099 ==========
    COMMON_PARAM_ERROR(40000, "参数非法"),
    PARAM_VALID_ERROR(40001, "参数校验失败"),
    REQUEST_BODY_ERROR(40002, "请求体格式错误"),
    BIND_PARAM_ERROR(40003,"表单参数绑定失败" ),
    NOT_FOUND_ERROR(40004, "请求接口不存在"),


    // ========== 通用认证权限 40100-40199 ==========
    TOKEN_INVALID(40100, "登录已失效，请重新登录"),
    NO_PERMISSION(40101, "暂无操作权限"),

    // ========== 通用服务异常 50000-50099 ==========
    SERVER_ERROR(50000, "服务器繁忙，请稍后重试"),
    DB_ERROR(50001, "数据库操作异常");

    private final Integer code;
    private final String msg;

    BaseResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}