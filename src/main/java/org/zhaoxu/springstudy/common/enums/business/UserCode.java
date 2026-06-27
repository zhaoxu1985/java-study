package org.zhaoxu.springstudy.common.enums.business;

import lombok.Getter;
import org.zhaoxu.springstudy.common.enums.IResultCode;

@Getter
public enum UserCode implements IResultCode {
    // 用户模块专属 41000 ~ 41099
    USER_NOT_EXIST(41000, "用户不存在"),
    USER_DISABLED(41001, "账号已被禁用"),
    USERNAME_EXIST(41002, "用户名已存在"),
    DELETE_FAIL(41003, "删除失败"),
    EDIT_FAIL(41004, "编辑用户失败");

    private final Integer code;
    private final String msg;

    UserCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
