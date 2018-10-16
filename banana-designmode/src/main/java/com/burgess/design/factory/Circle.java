package com.burgess.design.factory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.factory
 * @file Circle.java
 * @time 2018-10-16 13:35
 * @desc
 */
public class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
