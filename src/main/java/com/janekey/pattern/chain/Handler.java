/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.janekey.pattern.chain;

/**
 * @author cangfeng.zq
 * @version $Id: Handler.java, v 0.1 2017-01-12 ÏÂÎç9:05 cangfeng.zq Exp $
 */
public abstract class Handler {

    private Handler next;

    protected int   limit;

    public Handler(int limit) {
        this.limit = limit;
    }

    public void handleRequest(int count) {
        if (count < limit) {
            execute(count);
        } else if (next != null) {
            next.handleRequest(count);
        } else {
            System.out.println("no handler");
        }
    }

    public abstract void execute(int count);

    public void setNext(Handler next) {
        this.next = next;
    }
}
