package com.burgess.design.singleton;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.singleton
 * @file Singletonss.java
 * @time 2018-10-16 11:54
 * @desc 静态内部类单例模式(推荐使用)
 *      特点:
 *          （1）第一次加载Singleton类并不会初始化instance，只有在第一次使用getInstance时才会导致初始化；
 *          （2）第一次调用getInstance才会加载SingleHolder类，不仅能够确保线程安全，也能保证唯一性。
 */
public class Singletonss {

    private Singletonss(){}

    public static Singletonss getInstance(){
        return SingleHolder.instance;
    }

    private static class SingleHolder{
        private static final Singletonss instance = new Singletonss();
    }
}
