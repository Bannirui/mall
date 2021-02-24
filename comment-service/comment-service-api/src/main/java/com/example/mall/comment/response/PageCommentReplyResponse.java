package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
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
public class PageCommentReplyResponse extends AbstractResponse {
    private static final long serialVersionUID = 2488998624037391978L;
}
