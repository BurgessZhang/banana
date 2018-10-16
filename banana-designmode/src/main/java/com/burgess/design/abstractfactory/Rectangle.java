package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file Rectangle.java
 * @time 2018-10-16 13:43
 * @desc
 */
public class Rectangle implements Shape {


    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
