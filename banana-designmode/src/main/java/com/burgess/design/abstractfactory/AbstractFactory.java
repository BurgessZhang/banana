package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file AbstractFactory.java
 * @time 2018-10-16 13:47
 * @desc
 */
public abstract class AbstractFactory {

    abstract Color getColor(String color);

    abstract Shape getShape(String shapeType);

}
