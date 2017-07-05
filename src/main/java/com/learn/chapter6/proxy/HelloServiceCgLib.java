package com.learn.chapter6.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liushuwei on 2017/7/5.
 */
public class HelloServiceCgLib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("############This is JDK dynamic proxy#############");
        Object result = null;
        System.err.println("I'm going to say hello. ");
        result = methodProxy.invokeSuper(o, args);
        System.out.print("I have said hello. ");
        return result;
    }
}
