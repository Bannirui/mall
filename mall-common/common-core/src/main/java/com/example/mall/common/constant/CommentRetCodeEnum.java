package com.example.mall.common.constant;

import lombok.Getter;

/**
 * @author dingrui
 * @date 2021-02-24
 * @description comment-service统一错误码为
 */
@Getter
public enum CommentRetCodeEnum implements BaseEnum<String> {
    // 评论相关
    EXIST_SENSITIVE_WORDS(6002, "评论中存在敏感词"),
    CURRENT_ORDER_ITEM_EXISTS_COMMENT(6003, "当前商品已经评价, 不能重复添加"),
    COMMENT_NOT_EXIST(6004, "当前商品没有评价"),
    CURRENT_COMMENT_NOT_EXIST(6005, "该评价不存在"),
    REQUEST_PARAMETER_ERROR(6006, "请求参数错误"),
    ORIGIN_COMMENT_NOT_EXIST(6007, "原评价不存在"),
    CURRENT_COMMENT_REPLY_NOT_EXIST(6008, "该回复意见不存在");

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误提示信息
     */
    private final String msg;

    CommentRetCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param code
     * @return
     * @description 根据编码获取信息
     */
    @Override
    public String getMsgByCode(Integer code) {
        for (CommentRetCodeEnum value : values()) {
            if (value.code.equals(code)) {
                return value.msg;
            }
        }
        return null;
    }
}
