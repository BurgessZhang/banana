package com.burgess.design.factory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.factory
 * @file Square.java
 * @time 2018-10-16 13:34
 * @desc
 */
public class Square implements Shape{


    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
