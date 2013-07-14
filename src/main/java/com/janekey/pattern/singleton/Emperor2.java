package com.janekey.pattern.singleton;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午5:33
 */
public class Emperor2 {

    private static Emperor2 emperor2 = null;
    private static final Object object = new Object();

    private Emperor2() {
        //约束
    }

    public static Emperor2 getInstance() {
        if (emperor2 == null) {
            synchronized (object) {
                if (emperor2 == null)
                    emperor2 = new Emperor2();
            }
        }
        return emperor2;
    }

}
