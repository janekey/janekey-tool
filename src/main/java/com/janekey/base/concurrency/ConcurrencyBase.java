package com.janekey.base.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Administrator
 * Date: 13-7-10
 * Time: 下午11:10
 */
public class ConcurrencyBase {
    final static Object obj = new Object();

    //两种实现线程方法之一：实现Runnable接口
    static class ClassA implements Runnable {
        @Override
        public void run() {
            System.out.println("Here is a new thread from implements Runnable");

            System.out.println("ClassA sleeping 5s");
            try {
                //当前线程睡眠5秒
                Thread.sleep(5000);
                synchronized (obj) {
                    obj.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClassA wake up");
        }
    }

    //两种实现线程方法之一：继承Thread类
    static class ClassB extends Thread {
        @Override
        public void run() {
            System.out.println("Here is a new thread from extends Thread");

            System.out.println("ClassB wait");
            try {
                synchronized(obj) {
                    // 锁定对象，其他线程调用锁定对象的notify或notifyAll方法前，当前线程等待状态
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ClassB wake up");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ClassA());
        thread1.start();

        Thread thread2 = new ClassB();
        thread2.start();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("Here is a new thread from inner class");
            }
        };
        thread3.start();

        //使用Executor能更好的管理线程，还可以当线程执行完返回值
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++)
//            exec.execute(new ClassA());
//        exec.shutdown();
    }

}
