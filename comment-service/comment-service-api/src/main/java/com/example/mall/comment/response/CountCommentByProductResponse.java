package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
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
public class CountCommentByProductResponse extends AbstractResponse {
    private static final long serialVersionUID = 8828001891431505329L;
}
