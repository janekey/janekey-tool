package com.janekey.pattern.strategy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 上午11:48
 * 孙夫人断后，挡住追兵
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
