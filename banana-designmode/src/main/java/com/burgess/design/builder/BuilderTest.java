package com.burgess.design.builder;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.builder
 * @file BuilderTest.java
 * @time 2018-10-16 11:25
 * @desc 测试
 */
public class BuilderTest {

    public static void main(String[] args){
        Builder builder = new MyComputerBuilder();
        Direcror direcror = new Direcror(builder);
        direcror.createComputer("i7","Intel主板","ram");
    }
}
