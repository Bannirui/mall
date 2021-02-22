package com.example.mall.user.aop;

import com.example.mall.common.response.AbstractResponse;
import com.example.mall.user.annotation.ResponseExceptionHandler;
import com.example.mall.user.constant.SysRetCodeEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.validation.ValidationException;

/**
 *@author dingrui
 *@date 2021-02-20
 *@description 异常处理
 */
@Component
@Aspect
public class HandleResponseException {

    /**
     * @author dingrui
     * @date 2021/2/20
     * @return
     * @description 定义切面
     */
    @Pointcut(value = "@annotation(com.example.mall.user.annotation.ResponseExceptionHandler)")
    public void pointCut() {
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param pjp 方法
     * @param responseExceptionHandler 自定义注解
     * @return 方法执行异常返回自定义response
     * @description 环绕通知
     */
    @Around("pointCut() && @annotation(responseExceptionHandler)")
    public Object around(ProceedingJoinPoint pjp, ResponseExceptionHandler responseExceptionHandler) {
        Object result = null;
        AbstractResponse response = null;
        try {
            response = responseExceptionHandler.returnType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return result;
        }

        try {
            result = pjp.proceed();
        } catch (ValidationException e) {
            response.setCode(SysRetCodeEnum.REQUEST_CHECK_FAILURE.getCode());
            response.setMsg(SysRetCodeEnum.REQUEST_CHECK_FAILURE.getMessage());
            return response;
        } catch (Throwable e) {
            response.setCode(SysRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(SysRetCodeEnum.SYSTEM_ERROR.getMessage());
            return response;
        }
        return result;
    }
}
