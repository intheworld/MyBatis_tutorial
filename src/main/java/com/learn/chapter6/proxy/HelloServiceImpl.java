package com.learn.chapter6.proxy;

import com.learn.chapter6.proxy.HelloService;

/**
 * Created by liushuwei on 2017/7/5.
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
