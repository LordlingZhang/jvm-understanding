package com.zhangyu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangyu
 * @description : 运行时常量池(方法去)内存溢出OOM
 * VM args : -XX:PermSize=10M -XX:MaxPermSize=10M    1.8已经不支持permsize，去除了永久代
 *          -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @date : 2019/11/27
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        int i = 10;
        while (true){
            // intern可以不停的往常量池塞数据
            list.add(String.valueOf(i).intern());
        }
    }
}
