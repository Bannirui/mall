package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 根据商品评价计算综合评分
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductCommentScoreRequest extends AbstractRequest {
    private static final long serialVersionUID = -7835173241468097652L;
}
