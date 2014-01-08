package com.janekey.pattern.abstractfactory.human;

/**
 * User: jackeyzheng
 * Date: 14-1-8
 * Time: 下午5:18
 */
public abstract class AbstractWhiteHuman implements Human {
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
