package com.example.mall.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dingrui
 * @date 2021-02-23
 * @description 参数异常
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ValidateException extends BaseBusinessException {

    private static final long serialVersionUID = 6092575614122410221L;

    public ValidateException() {
        super();
    }

    public ValidateException(Integer code) {
        super();
        this.code = code;
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ValidateException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ValidateException(Integer code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }
}
