package com.janekey.pattern.multition;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午5:55
 */
public class Minister {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Emperor emperor = Emperor.getInstance();
            emperor.emperorInfo();
        }
    }

}
