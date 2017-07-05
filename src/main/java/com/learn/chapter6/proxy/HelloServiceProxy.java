package com.learn.chapter6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liushuwei on 2017/7/5.
 */
public class HelloServiceProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("############This is JDK dynamic proxy#############");
        Object result = null;
        System.err.println("I'm going to say hello. ");
        result = method.invoke(target, args);
        System.out.print("I have said hello. ");
        return result;
    }
}
