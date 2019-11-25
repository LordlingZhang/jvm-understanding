package com.zhangyu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangyu
 * @description : Java 堆内存溢出
 * VM args: -Xmx20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @date : 2019/11/26
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
