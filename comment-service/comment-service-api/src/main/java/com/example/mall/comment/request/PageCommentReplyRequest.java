package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 分页查询商品评价回复意见
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageCommentReplyRequest extends AbstractRequest {
    private static final long serialVersionUID = -7905721984430949548L;
}
