package org.example.ioc;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author XingKe
 * @date 2021-02-15 12:30
 */
//@Component
public class MyFactory implements FactoryBean<Car> {

    private String cardInfo;

    public MyFactory() {
        // 假装从Spring的配置文件中读到了值。
        this.cardInfo = "brand,100,200.12";;
    }

    /**
     * 向IOC容器中放入对象
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] cardInfoArray = cardInfo.split(",");
        car.setBrand(cardInfoArray[0]);
        car.setMaxSpeed(Integer.parseInt(cardInfoArray[1]));
        car.setPrice(Double.parseDouble(cardInfoArray[2]));
        return car;
    }

    /**
     * 向IOC容器返回指定的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 设置是否是单例模式
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
