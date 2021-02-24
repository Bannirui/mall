package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 新增商品评价回复
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AddCommentReplyRequest extends AbstractRequest {
    private static final long serialVersionUID = -5705713774528924309L;
}
