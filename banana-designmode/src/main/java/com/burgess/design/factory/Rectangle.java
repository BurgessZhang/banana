package com.burgess.design.factory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.factory
 * @file Rectangle.java
 * @time 2018-10-16 13:33
 * @desc
 */
public class Rectangle implements Shape{

    @Override
    public void draw(){
        System.out.println("Inside Rectangle::draw() method.");
    }

}
