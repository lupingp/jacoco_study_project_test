package com.example.studyprojectcontroller.study;

/**
 * @author luping
 * @date 2023/8/31 23:54
 */
public class StudyThread implements Runnable {

    /**
     * 线程状态 初始状态
     */
    public static void newThreads(){
        // Thread().getState()：返回这个线程的状态
        System.out.println("线程创建："+ new Thread().getState());
        // 线程创建：NEW
    }

    @Override
    public void run() {
        // Thread.currentThread()：返回当前正在执行的线程
        System.out.println("线程状态："+Thread.currentThread().getState());
    }

    public static void main(String[] args) {
//        StudyThread.newThreads();
        StudyThread studyThread = new StudyThread();
        Thread th = new Thread(studyThread);
        th.start();
        studyThread.run();
    }
}
