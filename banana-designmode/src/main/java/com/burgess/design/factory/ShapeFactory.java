package com.burgess.design.factory;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.factory
 * @file ShapeFactory.java
 * @time 2018-10-16 13:35
 * @desc 工厂
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
