package com.janekey.pattern.singleton;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午5:27
 * 皇帝，一般都是一个朝代有一个皇帝，所以作为单例模式
 */
public class Emperor {
    private static final Emperor emperor = new Emperor();

    private Emperor() {
        //约束，不让你产生第二个皇帝
    }

    public static Emperor getInstance() {
        return emperor;
    }

    public void emperorInfo() {
        System.out.println("我是皇帝X");
    }
}
