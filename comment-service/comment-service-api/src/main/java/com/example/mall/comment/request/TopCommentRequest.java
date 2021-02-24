package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
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
public class TopCommentRequest extends AbstractRequest {
    private static final long serialVersionUID = -7966504689443322546L;
}
