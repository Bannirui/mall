package com.example.mall.comment.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品评价回复表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-24
 */
@Data
@Builder
public class CommentReply implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 评价回复id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品评价id
     */
    private Long commentId;

    /**
     * 评价回复自关联id(针对回复的回复)
     */
    private Long parentId;

    /**
     * 回复意见
     */
    private String content;

    /**
     * 回复时间
     */
    private LocalDateTime replyTime;

    /**
     * 回复人昵称
     */
    private String replyNick;

    /**
     * 回复人用户id
     */
    private Long userId;

    /**
     * 是否删除 0未删除 1已删除
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
