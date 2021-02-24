package com.example.mall.comment.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品评价图片表
 * </p>
 *
 * @author dingrui
 * @since 2021-02-24
 */
@Data
@Builder
public class CommentPicture implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品评价图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品评价id
     */
    private Long commentId;

    /**
     * 图片路径
     */
    private String picPath;
}
