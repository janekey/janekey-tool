package com.janekey.pattern.factoryMethod;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午6:27
 */
public class BlackHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黑种人会笑");
    }

    @Override
    public void cry() {
        System.out.println("黑种人会哭");
    }

    @Override
    public void talk() {
        System.out.println("黑种人会说话");
    }
}
