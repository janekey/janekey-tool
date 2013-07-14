package com.janekey.pattern.strategy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 上午11:47
 * 找乔国老帮忙，使孙权不能杀刘备
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
