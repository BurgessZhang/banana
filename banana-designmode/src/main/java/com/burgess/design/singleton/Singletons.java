package com.burgess.design.singleton;


import java.util.Objects;

/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.singleton
 * @file Singletons.java
 * @time 2018-10-16 11:48
 * @desc 双重校验锁(Double CheckLock)单例模式(使用最多)
 *      特点:
 *          （1）明显继承了懒汉单例模式的所有优点和部分缺点（上述1、2、4条）；
 *          （2）第一次判空确保在被实例化后调用instance不再进行同步锁（明显是懒汉单例模式的升级版）。
 *          （3）第二次判空的原因是因为：一个线程进入synchronized块来初始化instance，而另一个线程则被阻断。当第一个线程退出synchronized块时，等待着的线程进入如果不判空就会创建另一个Singleton对象。
 */
public class Singletons {

    private static Singletons instance = null;

    private Singletons(){}

    public static Singletons getInstance(){
        if (Objects.isNull(instance)){
            synchronized (Singletons.class){
                if (Objects.isNull(instance)){
                    instance = new Singletons();
                    //此行代码会被编译成多条汇编指令，内部完成了三件事情
                    //第一，为Singleton实例分配内存；
                    //第二，调用构造函数初始化成员字段；
                    //第三，将instance对象指向分配的内存空间，此时instance!=null;
                    /*由于Java编译器允许处理器乱序执行（out-of-order），以及JDK1.5之前JMM（Java Memory Medel）中Cache、寄存器到主内存回写顺序的规定，上面的第二点和第三点的顺序是无法保证的，也就是说，执行顺序可能是1-2-3也可能是1-3-2，如果是后者，在3执行完毕并且2未执行之前，被切换到其他线程上，这时候instance已经是非空了，其他线程直接拿走instance使用，然后顺理成章地就会报错。
                    JDK1.5之后（使用volatile关键字）只需要将instance的定义改成如下形式，就可以保证instance每次都从主内存读取，就可以使用DCL的写法来完成单例模式。
                    private volatile static Singleton instance = null;
                    volatile关键字作用：
                    1.这个变量不会在多个线程中存在复本，直接从内存读取。
                    2.这个关键字会禁止指令重排序优化。也就是说，在 volatile 变量的赋值操作后面会有一个内存屏障（生成的汇编代码上），读操作不会在被重排序到内存屏障之前。*/
                }
            }
        }
        return instance;
    }

}
