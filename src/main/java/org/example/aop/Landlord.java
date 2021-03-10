package org.example.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author XingKe
 * @date 2021-02-27 10:30
 */
public class Landlord {

    public void rentHouse(int i) {
        i = 1 / 0;
        System.out.println(" 我向你提供房子..... ");
    }
}
