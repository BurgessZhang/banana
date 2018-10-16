package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file Square.java
 * @time 2018-10-16 13:44
 * @desc
 */
public class Square implements Shape {


    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
