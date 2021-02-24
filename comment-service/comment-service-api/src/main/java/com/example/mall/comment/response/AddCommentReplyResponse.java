package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
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
public class AddCommentReplyResponse extends AbstractResponse {
    private static final long serialVersionUID = 456827788195551051L;
}
