package com.example.mall.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

/**
 *@author dingrui
 *@date 2021-02-21
 *@description cookie工具类
 */
public class CookieUtil {

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param request
     * @param key
     * @return
     * @description 请求中获取cookie
     */
    public static String getCookieValue(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isNotEmpty(cookies)) {
            Optional<Cookie> first = Arrays.stream(cookies).filter(o -> StringUtils.equals(o.getName(), key)).findFirst();
            return first.map(Cookie::getValue).orElseGet(() -> null);
        }
        return null;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param key
     * @param value
     * @param uri
     * @param maxAge
     * @return
     * @description 生成cookie
     */
    public static Cookie genCookie(String key, String value, String uri, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        enrichCookie(cookie, uri, maxAge);
        return cookie;
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param cookie
     * @param uri
     * @param maxAge
     * @return
     * @description cookie信息完善
     */
    public static void enrichCookie(Cookie cookie, String uri, int maxAge) {
        cookie.setPath(uri);
        cookie.setMaxAge(maxAge);
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param response
     * @param cookie
     * @return
     * @description 响应中设置cookie
     */
    public static void setCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }
}
