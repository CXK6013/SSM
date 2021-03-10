package org.example.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author XingKe
 * @date 2021-02-27 16:15
 */
public class LandlordProxy implements MethodInterceptor {

    private Object object;

    public LandlordProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
