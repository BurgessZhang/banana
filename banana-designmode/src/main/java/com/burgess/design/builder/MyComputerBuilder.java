package com.burgess.design.builder;


/**
 * @author tom.zhang
 * @project banana
 * @package com.burgess.design.builder
 * @file MyComputerBuilder.java
 * @time 2018-10-16 11:19
 * @desc 建造者实现类
 */
public class MyComputerBuilder extends Builder{

    private Computer computer = new Computer();

    @Override
    public void buildCpu(String cpu) {
        computer.setmCpu(cpu);
    }

    @Override
    public void buildMainboard(String mainboard) {
        computer.setmMainboard(mainboard);
    }

    @Override
    public void buildRam(String ram) {
        computer.setmRam(ram);
    }

    @Override
    public Computer create() {
        return computer;
    }
}
