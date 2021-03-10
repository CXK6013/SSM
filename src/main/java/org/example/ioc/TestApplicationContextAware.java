package org.example.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author XingKe
 * @date 2021-02-15 13:57
 */
public class TestApplicationContextAware implements ApplicationContextAware, BeanNameAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setBeanName(String name) {

    }
}
