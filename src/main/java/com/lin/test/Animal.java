package com.lin.test;

/**
 * @author jianglinzou
 * @date 2019/8/29 下午4:50
 */
public class Animal extends ClassLoader {


    public void test() {
        eat();
    }

    public void eat() {
        System.out.println("吃东西");
    }
}
