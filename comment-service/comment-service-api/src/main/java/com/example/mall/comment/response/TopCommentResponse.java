package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 将商品评价置顶
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TopCommentResponse extends AbstractResponse {
    private static final long serialVersionUID = -6120251332302745930L;
}
