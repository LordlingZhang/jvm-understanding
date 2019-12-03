package com.zhangyu.jvm;

/**
 * @author : zhangyu
 * @description : java虚拟机栈 栈溢出 异常
 * 线程 请求栈深度大于允许的最大深度
 * VM args : -Xss160k
 * @date : 2019/11/26
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args){
        JavaVMStackSOF vm = new JavaVMStackSOF();
        try {
            vm.stackLeak();
        } catch (Throwable e) {
            System.out.println("当前栈深度："+ vm.stackLength);
            throw e;
        }

    }

    public  void stackLeak(){
        stackLength ++;
        stackLeak();
    }




}
