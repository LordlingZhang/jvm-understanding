package com.zhangyu.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : zhangyu
 * @description : 本机直接内存溢出(使用unsafe分配本机内存)
 * JVM Args ： -Xmx20M -XX:MaxDirectMemorySize=10M
 * @date : 2019/12/3
 */
public class DirectMemoryOOM {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1M);
        }

    }

}
