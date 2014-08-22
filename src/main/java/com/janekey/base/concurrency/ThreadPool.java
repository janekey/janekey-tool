package com.janekey.base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: p_qizheng
 * Date: 14-8-21
 * Time: 下午4:07
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();


        Executors.newFixedThreadPool(5);

        Executors.newSingleThreadExecutor();
    }

}
