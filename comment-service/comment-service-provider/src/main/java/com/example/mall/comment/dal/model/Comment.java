package com.example.mall.comment.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 商品评价表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-24
 */
@Data
@Builder
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品评论主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 类型: 1好评 2中评 3差评
     */
    private Integer type;

    /**
     * 是否匿名评价 0表示不是 1表示是
     */
    private Boolean isAnoymous;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 买家昵称
     */
    private String buyerNick;

    /**
     * 评价时间
     */
    private LocalDateTime commentTime;

    /**
     * 是否公开 1表示公开 0表示不公开
     */
    private Integer isPublic;

    /**
     * 是否通过审核
     */
    private Integer isValid;

    /**
     * 审核人id
     */
    private Long validationUserId;

    /**
     * 审核时间
     */
    private LocalDateTime validationTime;

    /**
     * 审核意见
     */
    private String validationSuggestion;

    /**
     * 是否置顶 0表示不置顶 1表示置顶
     */
    private Boolean isTop;

    /**
     * 评论用户id
     */
    private Long userId;

    /**
     * 是否删除 0表示不删除 1表示删除
     */
    private Boolean isDeleted;

    /**
     * 删除时间
     */
    private LocalDateTime deletionTime;

    /**
     * 删除用户id
     */
    private Long deletionUserId;
}
