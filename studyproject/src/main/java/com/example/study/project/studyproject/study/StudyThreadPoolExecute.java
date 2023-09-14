package com.example.study.project.studyproject.study;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.*;

/**
 * 学习多线程技术
 * 温故而知心
 */
public class StudyThreadPoolExecute {

    /**
     * 线程池使用execute执行Runnable任务，无返回值
     *
     * @throws Exception
     */
    public void ThreadPoolExecutorRunnable() throws Exception {
        // 创建线程池
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
                1,
                1,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2)
        );
        // 创建任务
        Runnable firstRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("【第一个任务执行...】");
                System.out.println(Thread.currentThread().getName());
            }
        };
        Runnable secondRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("【第二个任务执行...】");
                System.out.println(Thread.currentThread().getName());
            }
        };

//        System.out.println("【当前核心线程数是】："+threadExecutor.getPoolSize());
//        System.out.println("【当前最大线程数是】："+threadExecutor.getMaximumPoolSize());
//        System.out.println("【线程是否被关闭】："+threadExecutor.isTerminating());

        // 让线程池执行任务
        threadExecutor.execute(firstRunnable);
        threadExecutor.execute(secondRunnable);
        System.out.println("【当前最大线程队列容量是】："+threadExecutor.getQueue().size());
        System.out.println("【线程处理活跃状态的线程数是】："+threadExecutor.getActiveCount());
        threadExecutor.shutdown();
        System.out.println("【当前最大线程队列容量是】："+threadExecutor.getQueue().size());
        System.out.println("【线程处理活跃状态的线程数是】："+threadExecutor.getActiveCount());
        // 主线程睡眠1s
        Thread.sleep(1000);
        System.out.println("【主线程睡眠1s】");
    }


    /**
     * 线程池使用execute执行Callable任务，有返回值
     *
     * @throws Exception
     */
    public void ThreadPoolExecutorCallable() throws Exception {
        // 创建线程池
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300)
        );
        // 创建任务
        Callable<String> firstCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("【第一个任务执行...】");
                return "第一个任务执行";
            }
        };
        Callable<String> secondCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("【第二个任务执行...】");
                return "第二个任务执行";
            }
        };
        // 让线程池执行任务
        Future<String> fistFuture = threadExecutor.submit(firstCallable);
        Future<String> secondFuture = threadExecutor.submit(secondCallable);
        // 获取执行结果
        System.out.println("【第一个】：" + fistFuture.get());
        System.out.println("【第二个】：" + secondFuture.get());
        // 主线程睡眠1s
        Thread.sleep(1000);
        System.out.println("【主线程睡眠1s】");
    }


    public void ThreadPoolExecutorCallableThrow() throws Exception {
        // 创建线程池
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300)
        );
        // 创建任务
        Callable<String> firstCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("【第一个任务执行...】");
                throw new RuntimeException("线程任务执行报错");
            }
        };
        // 让线程池执行任务
        Future<String> fistFuture = threadExecutor.submit(firstCallable);
        // 获取执行结果
        System.out.println("【第一个】：" + fistFuture.get());
    }

    /**
     * 异步获取结果
     *
     * @param args
     * @throws Exception
     */
    public void ThreadPoolExecutorRunnables() throws Exception {
        // 创建线程池
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(
                2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300)
        );
        StudyResult studyResult = new StudyResult();

        // 创建任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                studyResult.setResult("任务执行了...");
            }
        };
        Future<StudyResult> futureResult = threadExecutor.submit(runnable, studyResult);
        // 获取执行结果
        StudyResult studyResult1 = futureResult.get();
        System.out.println(studyResult1.getResult());
    }


    public static void main(String[] args) throws Exception {
        StudyThreadPoolExecute studyThreadPoolExecute = new StudyThreadPoolExecute();
        studyThreadPoolExecute.ThreadPoolExecutorRunnable();
//        studyThreadPoolExecute.ThreadPoolExecutorCallable();
//        try {
//            studyThreadPoolExecute.ThreadPoolExecutorCallableThrow();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        studyThreadPoolExecute.ThreadPoolExecutorRunnables();

        System.out.println("CPU个数："+ Runtime.getRuntime().availableProcessors());

    }
}
