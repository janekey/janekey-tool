package com.janekey.pattern.factoryMethod;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午6:26
 */
public class WhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白种人会笑");
    }

    @Override
    public void cry() {
        System.out.println("白种人会哭");
    }

    @Override
    public void talk() {
        System.out.println("白种人会说话");
    }
}
