package com.burgess.design.singleton;


import java.util.Objects;

/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.singleton
 * @file Singletonl.java
 * @time 2018-10-16 11:41
 * @desc 懒汉模式(不建议使用)
 *      特点:
 *          (1）添加了synchronized关键字，保证在多线程下单例对象唯一；不使用该关键字的懒汉模式不是线程安全的。
 *          （2）单例只有在使用时才被实例化，一定程度上节约了资源，提高了效率；
 *          （3）即使instance已经被实例化，依旧存在不必要的synchronized同步开销，效率大大降低因此不建议使用该方式。
 *          （4）最后一个缺点就是第一次加载反应较慢
 */
public class Singletonl {

    private static Singletonl instance = null;

    private Singletonl(){}

    public static synchronized Singletonl getInstance(){
        if (Objects.isNull(instance)){
            instance = new Singletonl();
        }
        return instance;
    }
}
