package com.zhangyu.jvm;

/**
 * @author : zhangyu
 * @description : 创建线程导致的内存溢出
 * 扩展栈的时候没有足够的内存
 * VM args: -Xss2M
 * @date : 2019/11/27
 */
public class JavaVMStackOOM {

    public static void main(String[] args){
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public void dontStop(){
        while (true){

        }
    }
}
