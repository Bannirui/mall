package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 根据订单详情id查询评价
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GetCommentByOrderResponse extends AbstractResponse {
    private static final long serialVersionUID = -7549541381129493968L;
}
