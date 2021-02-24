package com.example.mall.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dingrui
 * @date 2021-02-23
 * @description 业务层异常类
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BizException extends BaseBusinessException {

    private static final long serialVersionUID = -5550223232632394159L;

    public BizException() {
        super();
    }

    public BizException(Integer code) {
        super();
        this.code = code;
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BizException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BizException(Integer code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }
}
