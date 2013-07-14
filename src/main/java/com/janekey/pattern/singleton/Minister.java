package com.janekey.pattern.singleton;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午5:30
 * 大臣每次看到的皇帝都是同一个人
 */
public class Minister {

    public static void main(String[] args) {
        Emperor emperor1 = Emperor.getInstance();
        emperor1.emperorInfo();

        Emperor emperor2 = Emperor.getInstance();
        emperor2.emperorInfo();

        Emperor emperor3 = Emperor.getInstance();
        emperor3.emperorInfo();

    }

}
