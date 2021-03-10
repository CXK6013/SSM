package org.example.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-27 20:16
 */
public class LogException implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println(method.getName()+"方法发生了异常");
    }
}
