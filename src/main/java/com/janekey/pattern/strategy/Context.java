package com.janekey.pattern.strategy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 上午11:49
 * 放计谋的锦囊（放策略的类）
 */
public class Context {

    private IStrategy strategy;

    //构造函数确定要使用哪个策略
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    //使用策略
    public void operate() {
        this.strategy.operate();
    }
}
