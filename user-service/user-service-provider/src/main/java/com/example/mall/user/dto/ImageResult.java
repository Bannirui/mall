package com.example.mall.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@author dingrui
 *@date 2021-02-22
 *@description 验证码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageResult implements Serializable {

    private static final long serialVersionUID = 8454840038470499128L;
    private String img;

    private String code;
}
