package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file Circle.java
 * @time 2018-10-16 13:44
 * @desc
 */
public class Circle implements Shape {


    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
