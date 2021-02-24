package com.example.mall.comment.response;

import com.example.mall.common.response.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description 商品评价审核
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AuditCommentResponse extends AbstractResponse {
    private static final long serialVersionUID = 6253714425138961943L;
}
