package com.zhangyu.jvm;

/**
 * @author : zhangyu
 * @description :  分配内存空间
 * JVM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @date : 2020/1/8
 */
public class Allocation {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        // 出现第一次Minor GC
        // 下面需要4M，不够，会执行分配担保，把新生代红的6M移到老年代，把allocation4放到新生代中
        allocation4 = new byte[4 * _1MB];
    }
}
