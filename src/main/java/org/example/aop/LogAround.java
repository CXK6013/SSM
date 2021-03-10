package org.example.aop;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-27 20:24
 */
public class LogAround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("这是环绕通知,在方法执行之前执行.........");
        Object result = null;
        try {
         //  invocation 控制目标方法的执行,注释这段,则目标方法不会执行。
         result = invocation.proceed();
        }catch (Exception ex){
            System.out.println("这是环绕通知,在方法执行之后执行.........，可以当做异常通知");
            // ex.printStackTrace();
        }
        System.out.println("这是环绕通知,在方法执行之后执行.........");
        return result;
    }
}
