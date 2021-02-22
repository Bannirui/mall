package com.example.mall.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 响应抽象
 */
@Data
public abstract class AbstractResponse implements Serializable {
    private static final long serialVersionUID = -1241729476259448231L;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;
}
