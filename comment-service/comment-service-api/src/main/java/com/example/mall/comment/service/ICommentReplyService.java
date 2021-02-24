package com.example.mall.comment.service;

import com.example.mall.comment.request.AddCommentReplyRequest;
import com.example.mall.comment.request.DeleteCommentReplyRequest;
import com.example.mall.comment.request.PageCommentReplyRequest;
import com.example.mall.comment.response.AddCommentReplyResponse;
import com.example.mall.comment.response.DeleteCommentReplyResponse;
import com.example.mall.comment.response.PageCommentReplyResponse;

/**
 * @author hepengshuai
 * @date 2019/8/21 20:46
 * 商品评价回复服务接口
 */
public interface ICommentReplyService {

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 新增商品评价回复
     */
    AddCommentReplyResponse addCommentReply(AddCommentReplyRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 删除商品评价回复
     */
    DeleteCommentReplyResponse deleteCommentReply(DeleteCommentReplyRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 分页查询商品评价回复意见
     */
    PageCommentReplyResponse commentReplyList(PageCommentReplyRequest request);
}
