package com.burgess.design.abstractfactory;

/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file Green.java
 * @time 2018-10-16 13:46
 * @desc
 */
public class Green implements Color {


    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
