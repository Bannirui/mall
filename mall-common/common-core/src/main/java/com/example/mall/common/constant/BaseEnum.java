package com.example.mall.common.constant;

import java.io.Serializable;

/**
 * @author dingrui
 * @date 2021-02-20
 * @description 服务响应码
 */
public interface BaseEnum<D> extends Serializable {
    /**
     * @author dingrui
     * @date 2021/2/24
     * @param code
     * @return
     * @description 根据编码获取信息
     */
    D getMsgByCode(Integer code);
}
