package com.example.mall.comment.dal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mall.comment.dal.mapper.CommentMapper;
import com.example.mall.comment.dal.model.Comment;
import com.example.mall.comment.dal.service.CommentDalService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品评价表 服务实现类
 * </p>
 *
 * @author dingrui
 * @since 2021-02-24
 */
@Service
public class CommentDalServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentDalService {

}
