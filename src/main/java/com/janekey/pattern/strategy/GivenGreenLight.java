package com.janekey.pattern.strategy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 上午11:47
 * 求吴国太开个绿灯
 */
public class GivenGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开个绿灯,放行！");
    }
}
