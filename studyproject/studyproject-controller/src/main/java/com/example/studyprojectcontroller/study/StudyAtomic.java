package com.example.studyprojectcontroller.study;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author luping
 * @date 2023/11/15 00:26
 */
public class StudyAtomic{

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * 设置指定值
     */
    public void getAndAdd() {
        atomicInteger.getAndAdd(-90);
        // 获取当前值
        System.out.println(atomicInteger.get());
    }

    /**
     * 增加值，自动+1
     */
    public void getAndIncrement() {
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }

    /**
     * 将当前值自动减1
     */
    public void getAndDecrement() {
        atomicInteger.getAndDecrement();
        System.out.println(atomicInteger.get());
    }

    public static void main(String[] args) throws InterruptedException {
        StudyAtomic studyAtomic = new StudyAtomic();
//        studyAtomic.getAndAdd();
//        studyAtomic.getAndIncrement();
//        studyAtomic.getAndDecrement();
        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    studyAtomic.getAndIncrement();
                }
            }
        };
        thread.start();
        thread.join();
        System.out.println("主线程执行："+atomicInteger.get());
    }
}
