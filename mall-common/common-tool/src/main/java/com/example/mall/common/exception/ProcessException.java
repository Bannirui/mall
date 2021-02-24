package com.example.mall.common.exception;

/**
 * @author dingrui
 * @date 2021-02-23
 * @description 业务处理异常
 */
public class ProcessException extends BaseBusinessException {
    private static final long serialVersionUID = 166203056206726108L;

    public ProcessException() {
        super();
    }

    public ProcessException(Integer code) {
        super();
        this.code = code;
    }

    public ProcessException(Throwable cause) {
        super(cause);
    }

    public ProcessException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ProcessException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ProcessException(Integer code, String msg, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }
}
