package com.burgess.design.abstractfactory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.abstractfactory
 * @file FactoryProducer.java
 * @time 2018-10-16 13:50
 * @desc
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
