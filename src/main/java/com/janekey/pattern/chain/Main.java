/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.janekey.pattern.chain;

import java.util.Random;

/**
 * @author cangfeng.zq
 * @version $Id: Main.java, v 0.1 2017-01-12 обнГ9:17 cangfeng.zq Exp $
 */
public class Main {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(5);
        Handler handler2 = new ConcreteHandler2(10);
        handler1.setNext(handler2);

        for (int i = 0; i < 50; i++) {
            int count = (new Random()).nextInt(10);
            handler1.handleRequest(count);
        }
    }

}
