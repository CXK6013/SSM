package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author XingKe
 * @date 2021-02-27 20:30
 */
@Aspect
@Component
public class LogAspectAnnotation {

    /**
     * Pointcut注解用于定义切点,可以被其他方法引用。
     * 相当于配置文件的: <aop:pointcut id = "pointCut" expression = "execution(public void org.example.aop.Landlord.rentHouse())"/>
     * Pointcut有两个属性一个是value用于指定execution表达式,argNames用于匹配参数取参数。
     * 记得语法是跟在配置文件中不同的是写完execution表达式,用&&args写参数名,多的用逗号隔开,在argNames中写对应的参数名
     * 然后在切点的方法中也要写,用于绑定参数。
     *
     * @param
     * @return
     */
    @Pointcut(value = "execution(public void org.example.aop.Landlord.rentHouse(int))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法调用执行之前执行");
    }

    /**
     * 相对于前置通知,AfterReturning中多了一个属性就是returning,用于获取目标方法的返回值。
     * returning中的值要和后置通知的参数名保持一致
     *
     * @param joinPoint
     * @param returningValue
     */
    @AfterReturning(value = "execution(public void org.example.aop.Landlord.rentHouse(int))", returning = "returningValue")
    public void after(JoinPoint joinPoint, Object returningValue) {
        System.out.println("方法的返回值是:" + returningValue);
        System.out.println("方法调用执行之后执行");
    }

    /**
     * 环绕通知用ProceedingJoinPoint来控制方法的执行
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(public void org.example.aop.Landlord.rentHouse(int))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知的前置通知........");
        Object result = null;
        try {
            // 控制方法的使用
            result = joinPoint.proceed();
            System.out.println("打印方法的返回值..........." + result);
        } catch (Exception e) {
            System.out.println("环绕通知的异常通知........");
        }
        System.out.println("环绕通知的后置通知........");
    }

    /**
     * throwing属性会将发生异常时的对象传递给方法的参数,所以throwing的属性值和参数名要保持一致
     * 发生了方法中的异常就会触发异常通知,当前方法就是ArithmeticException时触发
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public void org.example.aop.Landlord.rentHouse(int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, ArithmeticException ex) {
        System.out.println("这是异常通知的通知");
    }
}
