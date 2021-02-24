package com.example.mall.comment.request;

import com.example.mall.common.request.AbstractRequest;
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
public class AuditCommentRequest extends AbstractRequest {
    private static final long serialVersionUID = -3668736463906778124L;
}
