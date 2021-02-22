package com.example.mall.user.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.mall.common.response.ResponseData;
import com.example.mall.common.utils.CookieUtil;
import com.example.mall.user.annotation.Anoymous;
import com.example.mall.user.constant.SysRetCodeEnum;
import com.example.mall.user.request.CheckAuthRequest;
import com.example.mall.user.response.CheckAuthResponse;
import com.example.mall.user.service.IUserLoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description 用户认证适配器 拦截token认证 游客注解放行
 * HandlerInterceptorAdapter该类已经过时弃用
 */
public class TokenInterceptor implements HandlerInterceptor {

    private static final String ACCESS_TOKEN = "access_token";
    private static final String USER_INFO_KEY = "user_info";

    @DubboReference(timeout = 3000)
    IUserLoginService iUserLoginService;

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @param response
     * @param handler
     * @return 返回true表示该调用链已经处理结束后 需要下一环节处理请求 返回false表示不需要下一环节处理 也就是说拒绝登陆
     * @description 登陆前验证
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            // 是否是当前处理环节 如果不是 交给下一调用链
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (isAnoymous(handlerMethod)) {
            // 匿名访问
            return true;
        }
        // 不是匿名访问对请求token进行认证
        String token = CookieUtil.getCookieValue(request, ACCESS_TOKEN);
        if (StringUtils.isEmpty(token)) {
            // 请求中没有解析出token token失效
            ResponseData<Object> responseData = ResponseData.error("token已失效");
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(responseData));
            return false;
        }
        // 请求中有token 对token进行认证
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(token);
        CheckAuthResponse checkAuthResponse = iUserLoginService.validToken(checkAuthRequest);
        if (SysRetCodeEnum.SUCCESS.getCode().equals(checkAuthResponse.getCode())) {
            // 通过token认证 保存token解析后的信息到request中 后续继续使用
            request.setAttribute(USER_INFO_KEY,checkAuthResponse.getUserInfo());
            return true;
        }
        // 没通过token认证
        ResponseData<Object> responseData = ResponseData.error(checkAuthResponse.getMsg());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(responseData));
        return false;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param handlerMethod
     * @return true表示匿名访问 false表示不是匿名访问
     * @description 是否匿名访问 匿名访问不需要认证
     * 类或者方法是否有@Anoymous注解 有就是匿名访问
     */
    private boolean isAnoymous(HandlerMethod handlerMethod) {
        Class<?> clazz = handlerMethod.getBean().getClass();
        if (clazz.getAnnotation(Anoymous.class) != null) {
            return true;
        }
        return (handlerMethod.getMethod().getAnnotation(Anoymous.class)) != null;
    }
}
