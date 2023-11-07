package com.example.studyprojectcontroller.study;

/**
 * @author luping
 * @date 2023/8/31 23:59
 */
public class StudyBlockThread extends Thread {

    /**
     * 线程名称
     */
    private String name;

    /**
     * 锁
     */
    private Object lock;

    public StudyBlockThread(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("线程名称：" + name + " " + "线程状态：" + Thread.currentThread().getState());
        synchronized (lock) {
            System.out.println("线程：" + name + " " + "获取锁");
            try {
                System.out.println("线程：" + name + " " + "开始执行逻辑..." + "线程状态：" + Thread.currentThread().getState());
                Thread.sleep(1);
//                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("线程：" + name + " " + "执行逻辑错误..." + "异常信息：" + e.getMessage());
            }
            System.out.println("线程：" + name + " " + "逻辑执行完成..." + "线程状态：" + Thread.currentThread().getState());
            System.out.println("线程：" + name + " " + "执行完成开始释放锁...");
        }
    }

    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        StudyBlockThread studyThread1 = new StudyBlockThread("张三", lock);
        StudyBlockThread studyThread2 = new StudyBlockThread("李四", lock);
        studyThread1.start();
        studyThread2.start();
        Thread.sleep(100);
        System.out.println("线程studyThread1状态：" + studyThread1.getState()+"线程名称："+Thread.currentThread().getName());
        System.out.println("线程studyThread2状态：" + studyThread2.getState()+"线程名称："+Thread.currentThread().getName());
    }
}
