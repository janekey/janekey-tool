package com.janekey.base.concurrency;

import java.util.concurrent.*;

/**
 * User: p_qizheng
 * Date: 14-8-21
 * Time: 下午4:07
 */
public class ThreadPool {

    public static void main(String[] args) {
        /**
         * corePoolSize|maximumPoolSize|keepAliveTime|unit|workQueue
         * 各参数说明具体参考API
         */

        /**
         * 【CachedThreadPool无界线程池】,线程自动回收
         * corePoolSize:0|maximumPoolSize:MAX_VALUE|keepAliveTime:60s|任务队列:SynchronousQueue
         * 新任务提交后，创建新线程处理任务，无上限
         */
//        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 【FixedThreadPool固定大小线程池】
         * corePoolSize:参数|maximumPoolSize:参数|keepAliveTime:0|任务队列:LinkedBlockingQueue
         * 固定线程数，任务数超过则进队列排队，队列无上限
         */
//        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /**
         * 【SingleThread单线程池】
         * corePoolSize:1|maximumPoolSize:1|keepAliveTime:0|任务队列:LinkedBlockingQueue
         * 单个线程执行任务，前面任务为完成，后面任务紧队列排队，队列无上线
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        for (int i = 0; i < 100; i++) {
//            Task task = new Task(i);
//            executorService.execute(task);
//        }

        Future<String> future = executorService.submit(new TaskWithResult());
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    static class Task implements Runnable {
        private int tag;
        public Task(int tag) {
            this.tag = tag;
        }
        @Override
        public void run() {
            System.out.println("tag:" + tag);
        }
    }

    static class TaskWithResult implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "result";
        }
    }

}
