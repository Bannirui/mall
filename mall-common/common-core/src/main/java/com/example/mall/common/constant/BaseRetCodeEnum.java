package com.example.mall.common.constant;

import lombok.Getter;

/**
 * @author dingrui
 * @date 2021-02-20
 * @description 服务响应码
 */
@Getter
public enum BaseRetCodeEnum implements BaseEnum<String> {

    // 通用
    SUCCESS(2000, "成功"),
    REQUEST_FORMAT_ILLEGAL(2001, "请求数据格式非法"),
    REQUEST_IP_ILLEGAL(2002, "请求IP非法"),
    REQUEST_CHECK_FAILURE(2003, "请求数据校验失败"),
    DATA_NOT_EXIST(2004, "数据不存在"),
    DATA_REPEATED(2005, "数据重复"),
    REQUEST_DATA_NOT_EXIST(2006, "传入对象不能为空"),
    REQUEST_DATA_ERROR(2007, "必要的参数不正确"),
    REQUISITE_PARAMETER_NOT_EXIST(2008, "必要的参数不能为空"),
    PERMISSION_DENIED(2009, "权限不足"),
    DB_EXCEPTION(2010, "数据库异常"),
    SYSTEM_TIMEOUT(2011, "系统超时"),
    SYSTEM_ERROR(2012, "系统错误");

    /**
     * 编码
     */
    private final Integer code;

    /**
     * 信息
     */
    private final String msg;

    BaseRetCodeEnum(Integer code, String msg) {
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
        for (BaseRetCodeEnum s : BaseRetCodeEnum.values()) {
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
