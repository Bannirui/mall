package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 查询某个商品的评价总数
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CountCommentByProductRequest extends AbstractRequest {
    private static final long serialVersionUID = 7467956597059948343L;
}
