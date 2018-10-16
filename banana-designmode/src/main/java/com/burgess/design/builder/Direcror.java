package com.burgess.design.builder;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.builder
 * @file Direcror.java
 * @time 2018-10-16 11:22
 * @desc 指挥者
 */
public class Direcror {

    Builder builder = null;

    public Direcror(Builder builder){
        this.builder = builder;
    }

    /**
     * @file Direcror.java
     * @method createComputer
     * @desc 规范建造流程，指定顺序
     * @author free.zhang
     * @date 2018/10/16 11:24
     * @param '[cpu, mainboard, ram]
     * @return com.burgess.design.builder.Computer
     */
    public Computer createComputer(String cpu,String mainboard,String ram){
        this.builder.buildMainboard(mainboard);
        this.builder.buildCpu(cpu);
        this.builder.buildRam(ram);

        return builder.create();
    }

}
