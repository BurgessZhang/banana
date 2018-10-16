package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file Red.java
 * @time 2018-10-16 13:45
 * @desc
 */
public class Red implements Color{


    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
