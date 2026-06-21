package org.zhaoxu.springstudy.common.exception;

import org.zhaoxu.springstudy.common.enums.IResultCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final IResultCode codeEnum;

    public BusinessException(IResultCode codeEnum) {
        super(codeEnum.getMsg());
        this.codeEnum = codeEnum;
    }

    public BusinessException(IResultCode codeEnum, String msg) {
        super(msg);
        this.codeEnum = codeEnum;
    }
}