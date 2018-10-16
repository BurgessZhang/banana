package com.burgess.design.singleton;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.singleton
 * @file Singletone.java
 * @time 2018-10-16 11:29
 * @desc 饿汉单例模式
 *       特点:
 *       （1）不能通过new的形式构造对象（构造函数已经私有化）；
 *       （2）只能通过Singleton.getInstance()静态方法获取这个静态对象；
 *       （3）加载此类时就创建了唯一实例，JVM保证在任何线程访问instance之前都会创建完毕；
 *       （4）适合单例对象初始化占用内存小、快速并且使用频繁的情况
 */
public class Singletone {

    public static Singletone instance = new Singletone();

    private Singletone(){}

    public static  Singletone getInstance(){
        return instance;
    }

}
