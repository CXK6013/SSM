package org.example.aop;

/**
 * @author XingKe
 * @date 2021-02-27 10:31
 */
public class HouseAgent implements IRentHouse {

    @Override
    public void rentHouse() {
        System.out.println("在该类的方法之前执行该方法");
//        IRentHouse landlord = new Landlord();
//        landlord.rentHouse();
        System.out.println("在该类的方法之后执行该方法");
    }
}
