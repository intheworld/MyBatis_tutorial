package com.learn.chapter6.proxy;

/**
 * Created by liushuwei on 2017/7/5.
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloHandler = new HelloServiceProxy();
        HelloService proxy = (HelloService)helloHandler.bind(new HelloServiceImpl());
        proxy.sayHello("Bruce Wayne");
    }
}
