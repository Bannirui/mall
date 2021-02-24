package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
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
public class PageCommentByProductResponse extends AbstractResponse {
    private static final long serialVersionUID = 1093651105002893958L;
}
