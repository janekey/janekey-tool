/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.janekey.pattern.chain;

/**
 * @author cangfeng.zq
 * @version $Id: ConcreteHandler1.java, v 0.1 2017-01-12 обнГ9:16 cangfeng.zq Exp $
 */
public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(int limit) {
        super(limit);
    }

    @Override
    public void execute(int count) {
        System.out.println(this.getClass().getSimpleName() + ":" + count);
    }
}
