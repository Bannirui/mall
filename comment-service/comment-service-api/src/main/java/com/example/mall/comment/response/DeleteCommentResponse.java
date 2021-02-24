package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 删除评价
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DeleteCommentResponse extends AbstractResponse {
    private static final long serialVersionUID = 1323005402592200255L;
}
