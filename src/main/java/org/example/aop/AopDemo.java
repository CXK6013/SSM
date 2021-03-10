package org.example.aop;


import net.sf.cglib.proxy.Enhancer;
import org.example.ioc.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.*;

/**
 * @author XingKe
 * @date 2021-02-27 10:33
 */
public class AopDemo {
    public static void main(String[] args) throws Exception {
        testLogAop();

    }

    private static void testLogAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Landlord landlord = applicationContext.getBean("landlord", Landlord.class);
        landlord.rentHouse(1);
    }

    private static void cglibDemo() {
        // 一般都是从Enhancer出手
        Enhancer enhancer = new Enhancer();
        // 设置需要增强的类。
        enhancer.setSuperclass(Car.class);
        // 设置增强类的实际增强者
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建实际的代理类
        Car car = (Car) enhancer.create();
        System.out.println(car.getBrand());
        car.setBrand("aaa");
    }

//    private static void dynamicProxyPro() {
//        IRentHouse iRentHouse = new Landlord();
//        IRentHouse proxy = (IRentHouse) getProxyPlus(iRentHouse);
//        proxy.rentHouse();
//    }

    private static Object getProxyPlus(final Object target) {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法开始执行..........");
                Object obj = method.invoke(target, args);
                System.out.println("方法执行结束");
                return obj;
            }
        });
        return proxy;
    }

//    private static void dynamicProxyPlus() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        IRentHouse iRentHouse = new Landlord();
//        iRentHouse = (IRentHouse) getProxy(iRentHouse);
//        iRentHouse.rentHouse();
//    }

    /**
     * 参数为目标对象
     *
     * @param target
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static Object getProxy(final Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> proxyClazz = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor<?> constructor = proxyClazz.getConstructor(InvocationHandler.class);
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + "方法开始执行..........");
                Object object = method.invoke(target, args);
                System.out.println(method.getName() + "方法执行结束..........");
                return object;
            }
        });
        return proxy;
    }

    private static Object dynamicProxy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         *  第一个参数为目标类的加载器
         *  第二个参数为目标类和代理类需要实现的接口
         */
        Class<?> rentHouseProxy = Proxy.getProxyClass(IRentHouse.class.getClassLoader(), IRentHouse.class);
        //这种由JDK动态代理的类，会有一个参数类型为InvocationHandler的构造函数。我们通过反射来获取
        Constructor<?> constructor = rentHouseProxy.getConstructor(InvocationHandler.class);
        // 通过反射创建对象，向其传入InvocationHandler对象，目标类和代理类共同实现的接口中的方法被调用时,会先调用
        // InvocationHandler的invoke方法有目标对象需要增强的方法。为目标对象需要增强的方法调用所需要的的参数
        IRentHouse iRentHouseProxy = (IRentHouse) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                IRentHouse iRentHouse = new Landlord();
                System.out.println("方法调用之前.............");
//                Object result = method.invoke(iRentHouse, args);
                System.out.println("方法调用之后.............");
                return null;
            }
        });
        return iRentHouseProxy;
    }

    private static void staticProxy() {
        IRentHouse landlord = new HouseAgent();
        landlord.rentHouse();
    }
}
