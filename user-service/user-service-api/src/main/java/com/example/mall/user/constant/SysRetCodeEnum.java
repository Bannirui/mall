package com.example.mall.user.constant;

import lombok.Getter;

/**
 * @author dingrui
 * @date 2021-02-20
 * @description 响应码
 */
@Getter
public enum SysRetCodeEnum {
    // 系统公用
    SUCCESS(200, "成功"),

    USERORPASSWORD_ERRROR(3001, "用户名或密码不正确"),
    TOKEN_VALID_FAILED(3002, "token校验失败"),
    USERNAME_ALREADY_EXISTS(3003, "用户名已存在"),
    USER_REGISTER_FAILED(3004, "注册失败，请联系管理员"),
    KAPTCHA_CODE_ERROR(3005, "验证码不正确"),
    USER_ISVERFIED_ERROR(3006, "用户名尚未激活"),
    USER_REGISTER_VERIFY_FAILED(3007, "用户注册失败插入验证数据失败"),
    USER_INFOR_INVALID(3004, "用户信息不合法"),

    REQUEST_FORMAT_ILLEGAL(3060, "请求数据格式非法"),
    REQUEST_IP_ILLEGAL(3061, "请求IP非法"),
    REQUEST_CHECK_FAILURE(3062, "请求数据校验失败"),
    DATA_NOT_EXIST(3070, "数据不存在"),
    DATA_REPEATED(3071, "数据重复"),
    REQUEST_DATA_NOT_EXIST(3072, "传入对象不能为空"),
    REQUEST_DATA_ERROR(3074, "必要的参数不正确"),
    REQUISITE_PARAMETER_NOT_EXIST(3073, "必要的参数不能为空"),
    PERMISSION_DENIED(3091, "权限不足"),
    DB_EXCEPTION(3097, "数据库异常"),
    SYSTEM_TIMEOUT(3098, "系统超时"),
    SYSTEM_ERROR(3099, "系统错误"),

    USERVERIFY_INFOR_INVALID(3200, "用户注册验证验证信息不合法");

    /**
     * 编码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    SysRetCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @author dingrui
     * @date 2021/2/20
     * @param code 编码
     * @return
     * @description 根据编码获取信息
     */
    public static String getMessageByCode(Integer code) {
        for (SysRetCodeEnum s : SysRetCodeEnum.values()) {
            if (null == code) {
                break;
            }
            if (s.code.equals(code)) {
                return s.message;
            }
        }
        return null;
    }
}
