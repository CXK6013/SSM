package org.example.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-27 17:36
 */
public class LogBefore implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object o) throws Throwable {
        System.out.println("方法调用执行之前执行");
    }
}
