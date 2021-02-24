package com.example.mall.common.constant;

import lombok.Getter;

/**
 * @author dingrui
 * @date 2021-02-20
 * @description user-service响应码
 */
@Getter
public enum UserRetCodeEnum implements BaseEnum<String> {

    // 用户相关
    USER_OR_PASSWORD_ERRROR(3001, "用户名或密码不正确"),
    TOKEN_VALID_FAILED(3002, "token校验失败"),
    USERNAME_ALREADY_EXISTS(3003, "用户名已存在"),
    USER_REGISTER_FAILED(3004, "注册失败，请联系管理员"),
    KAPTCHA_CODE_ERROR(3005, "验证码不正确"),
    USER_ISVERFIED_ERROR(3006, "用户名尚未激活"),
    USER_REGISTER_VERIFY_FAILED(3007, "用户注册失败插入验证数据失败"),
    USER_INFOR_INVALID(3004, "用户信息不合法"),
    USERVERIFY_INFOR_INVALID(3200, "用户注册验证验证信息不合法");

    /**
     * 编码
     */
    private final Integer code;

    /**
     * 信息
     */
    private final String msg;

    UserRetCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param code
     * @return
     * @description 根据编码获取信息
     */
    @Override
    public String getMsgByCode(Integer code) {
        for (UserRetCodeEnum s : UserRetCodeEnum.values()) {
            if (null == code) {
                break;
            }
            if (s.code.equals(code)) {
                return s.msg;
            }
        }
        return null;
    }
}
