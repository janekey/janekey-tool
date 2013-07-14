package com.janekey.pattern.proxy;

/**
 * User: Administrator
 * Date: 13-7-14
 * Time: 下午4:03
 */
public class PanJinLian implements Women {
    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲和男人happy");
    }
}
