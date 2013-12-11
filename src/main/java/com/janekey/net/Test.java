package com.janekey.net;

import java.net.InetAddress;

/**
 * User: jackeyzheng
 * Date: 13-12-11
 * Time: 下午5:18
 */
public class Test {

    public static void main(String[] args) {
        try {
            InetAddress i = InetAddress.getByName("baidu");
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
