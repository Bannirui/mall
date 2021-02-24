package com.example.mall.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dingrui
 * @date 2021-02-23
 * @description 异常基类
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1425162833839826893L;
    /**
     * 异常编号
     */
    protected Integer code;

    /**
     * 异常信息
     */
    protected String msg;

    protected String extFields;

    public BaseBusinessException() {
        super();
    }

    public BaseBusinessException(Integer code) {
        super();
        this.code = code;
    }

    public BaseBusinessException(Throwable cause) {
        super(cause);
    }

    public BaseBusinessException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BaseBusinessException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseBusinessException(Integer code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public BaseBusinessException(Integer code, String msg, String extFields, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
        this.extFields = extFields;
    }
}
