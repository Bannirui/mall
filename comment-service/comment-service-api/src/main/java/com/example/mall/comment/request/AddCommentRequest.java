package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 添加商品评价
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddCommentRequest extends AbstractRequest {
    private static final long serialVersionUID = -788301971094833294L;
}
