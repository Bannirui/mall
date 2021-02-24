package com.example.mall.user.service;

import com.example.mall.common.annotation.ResponseExceptionHandler;
import com.example.mall.common.constant.BaseRetCodeEnum;
import com.example.mall.common.constant.UserRetCodeEnum;
import com.example.mall.user.dto.ImageResult;
import com.example.mall.user.request.KaptchaCodeRequest;
import com.example.mall.user.response.KaptchaCodeResponse;
import com.example.mall.user.utils.VerifyCodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 图形验证码
 */
@DubboService
public class KaptchaServiceImpl implements IKaptchaService {

    private final String KAPTCHA_UUID = "kaptcha_uuid";

    @Autowired
    ValueOperations<String, String> valueOperations;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 获取图形验证码
     */
    @Override
    public KaptchaCodeResponse getKaptchaCode(KaptchaCodeRequest request) {
        KaptchaCodeResponse response = new KaptchaCodeResponse();
        try {
            ImageResult imageResult = VerifyCodeUtil.genVerifyCode(140, 43, 4);
            String uuid = UUID.randomUUID().toString();
            // 将验证码附带uuid唯一值 存到redis key=kaptcha_uuid+uuid value=验证码 过期时间60s
            valueOperations.set(KAPTCHA_UUID + uuid, imageResult.getCode(), 60, TimeUnit.SECONDS);
            response.setCode(BaseRetCodeEnum.SUCCESS.getCode());
            response.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
            response.setImageCode(imageResult.getCode());
            response.setUuid(uuid);
        } catch (IOException e) {
            response.setCode(BaseRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(BaseRetCodeEnum.SYSTEM_ERROR.getMsg());
        }
        return response;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @return
     * @description 验证图形验证码
     * 客户端存储着生成验证码时的uuid
     * 根据客户端uuid取redis中找缓存的验证码
     * 比较客户端的验证码和redis中的验证码
     */
    @ResponseExceptionHandler(returnType = KaptchaCodeResponse.class)
    @Override
    public KaptchaCodeResponse validateKaptchaCode(@NotNull @Validated KaptchaCodeRequest request) {
        KaptchaCodeResponse kaptchaCodeResponse = new KaptchaCodeResponse();
        // redis中key
        String redisKey = KAPTCHA_UUID + request.getUuid();
        // 从redis中取出value
        String code = valueOperations.get(redisKey);
        if (StringUtils.isNotBlank(code) && request.getCode().equalsIgnoreCase(code)) {
            kaptchaCodeResponse.setCode(BaseRetCodeEnum.SUCCESS.getCode());
            kaptchaCodeResponse.setMsg(BaseRetCodeEnum.SUCCESS.getMsg());
            return kaptchaCodeResponse;
        }
        kaptchaCodeResponse.setCode(UserRetCodeEnum.KAPTCHA_CODE_ERROR.getCode());
        kaptchaCodeResponse.setMsg(UserRetCodeEnum.KAPTCHA_CODE_ERROR.getMsg());
        return kaptchaCodeResponse;
    }
}
