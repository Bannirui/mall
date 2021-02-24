package com.example.mall.common.aop;

import com.example.mall.common.annotation.ResponseExceptionHandler;
import com.example.mall.common.constant.BaseRetCodeEnum;
import com.example.mall.common.response.AbstractResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;


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
    @Pointcut(value = "@annotation(com.example.mall.common.annotation.ResponseExceptionHandler)")
    public void pointCut() {
    }

    /**
     * @author dingrui
     * @date 2021/2/21
     * @param pjp 方法
     * @param annotation 自定义注解
     * @return 方法执行异常返回自定义response
     * @description 环绕通知
     */
    @Around("pointCut() && @annotation(annotation)")
    public Object around(ProceedingJoinPoint pjp, ResponseExceptionHandler annotation) {
        Object result = null;
        AbstractResponse response = null;
        try {
            response = annotation.returnType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return result;
        }

        try {
            result = pjp.proceed();
        } catch (ValidationException e) {
            response.setCode(BaseRetCodeEnum.REQUEST_CHECK_FAILURE.getCode());
            response.setMsg(BaseRetCodeEnum.REQUEST_CHECK_FAILURE.getMsg());
            return response;
        } catch (Throwable e) {
            response.setCode(BaseRetCodeEnum.SYSTEM_ERROR.getCode());
            response.setMsg(BaseRetCodeEnum.SYSTEM_ERROR.getMsg());
            return response;
        }
        return result;
    }
}
