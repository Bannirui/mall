package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 分页查询某个商品的评价
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageCommentByProductRequest extends AbstractRequest {
    private static final long serialVersionUID = 5892536839567304467L;
}
