package com.zhangyu.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : zhangyu
 * @description :  借助CGLib使方法区出现内存溢出异常
 * VM args : -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @date : 2019/12/3
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args){

        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObj.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObj{}

}
