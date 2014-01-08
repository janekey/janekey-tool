package com.janekey.pattern.factory;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午6:26
 */
public class YelloHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人会笑");
    }

    @Override
    public void cry() {
        System.out.println("黄种人会哭");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会说话");
    }
}
