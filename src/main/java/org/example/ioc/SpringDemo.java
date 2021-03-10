package org.example.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XingKe
 * @date 2021-02-12 17:20
 */

public class SpringDemo {

    public static void main(String[] args) {
        testFactoryBean();
    }

    private static void testFactoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 代表取MyFactory
        MyFactory myFactory = applicationContext.getBean("&myFactory", MyFactory.class);
        // 不加&代表取工厂中放入的bean
        Car car = applicationContext.getBean("myFactory", Car.class);
        System.out.println(myFactory);
        System.out.println(car);
    }

    private static void annotationPrintAllBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    private static void annotationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.print();
    }

    private static void xmlTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student1 = (Student) applicationContext.getBean("student");
        Student student2 = (Student) applicationContext.getBean("student");
        System.out.println(student1 == student2);
    }
}
