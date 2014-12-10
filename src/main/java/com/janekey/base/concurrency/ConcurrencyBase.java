package com.janekey.base.concurrency;

import java.util.concurrent.TimeUnit;

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
    static Thread t ;
    public static void main(String[] args) {
        //一、继承Runnable接口方式
        Thread thread1 = new Thread(new ClassA());
        t = thread1;
        thread1.start();

        //二、继承Thread类方式
        Thread thread2 = new ClassB();
        thread2.start();

        //三、匿名类方式
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                try {
                    //Java 5/6的sleep风格,不用Thread.sleep()
                    TimeUnit.MILLISECONDS.sleep(100);

                    //设置优先级，JDK默认有10级，不过实际各系统的级别不一样。Windows有7级、Solaris有23级。
                    // 建议使用MIN_PRIORITY、NORM_PRIORITY、MAX_PRIORITY
                    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

                    //暂停当前线程对象，并执行其他线程
                    Thread.yield();

                    //等待t线程结束
                    t.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Here is a new thread from inner class");
                throw new RuntimeException("test");
            }
        };
        //捕获线程中的异常
        thread3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("caught:" + e);
            }
        });
        thread3.start();
    }

}
