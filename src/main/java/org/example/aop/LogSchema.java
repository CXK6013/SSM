package org.example.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-28 13:42
 */
@Component
public class LogSchema {


    public void before(JoinPoint joinPoint) {
        System.out.println("z方法调用执行之前执行");
    }

    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("z环绕通知的前置通知........");
        Object result = null;
        try {
            // 控制方法的使用
            result = joinPoint.proceed();
            System.out.println("z打印方法的返回值..........." + result);
        } catch (Exception e) {
            System.out.println("z环绕通知的异常通知........");
        }
        System.out.println("z环绕通知的后置通知........");
    }


    public void after(JoinPoint joinPoint, Object returningValue) {
        System.out.println("z方法的返回值是:" + returningValue);
        System.out.println("z方法调用执行之后执行");
    }


    public void afterThrowing(JoinPoint joinPoint, ArithmeticException ex) {
        System.out.println("z这是异常通知的通知");
    }
}
