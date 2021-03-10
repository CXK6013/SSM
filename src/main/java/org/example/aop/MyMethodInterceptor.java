package org.example.aop;



import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-27 16:24
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行前执行");
        System.out.println(args);
        Object returnValue = methodProxy.invokeSuper(obj, args);
        System.out.println("方法执行后执行");
        return returnValue;
    }
}
