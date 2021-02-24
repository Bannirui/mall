package com.example.mall.comment.service;

import com.example.mall.comment.request.*;
import com.example.mall.comment.response.*;

/**
 * @author dingrui
 * @date 2021-02-24
 * @description 商品评价服务接口
 */
public interface ICommentService {

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request 请求参数
     * @return 评价结果
     * @description 添加商品评价
     */
    AddCommentResponse addComment(AddCommentRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 根据订单详情id查询评价
     */
    GetCommentByOrderResponse getCommentByOrder(GetCommentByOrderRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 分页查询某个商品的评价
     */
    PageCommentByProductResponse pageCommentByProduct(PageCommentByProductRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 查询某个商品的评价总数
     */
    CountCommentByProductResponse countCommentByProduct(CountCommentByProductRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 删除评价
     */
    DeleteCommentResponse deleteComment(DeleteCommentRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 将商品评价置顶
     */
    TopCommentResponse topComment(TopCommentRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 商品评价审核
     */
    AuditCommentResponse auditComment(AuditCommentRequest request);

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param request
     * @return
     * @description 根据商品评价计算综合评分
     */
    ProductCommentScoreResponse itemScore(ProductCommentScoreRequest request);
}
