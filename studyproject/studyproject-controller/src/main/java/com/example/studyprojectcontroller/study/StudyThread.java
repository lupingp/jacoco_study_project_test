package com.example.studyprojectcontroller.study;

/**
 * @author luping
 * @date 2023/8/31 23:54
 */
public class StudyThread implements Runnable {

    private String sharedResource;
    private final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            while (sharedResource == null) {
                try {
                    System.out.println("等待资源..." + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("lock.wait()。。。" + Thread.currentThread().getName());
                    System.out.println("收到资源...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 使用资源...
            System.out.println("使用资源..." + Thread.currentThread().getName());
            System.out.println(sharedResource);
        }
    }


    public void setSharedResource(String sharedResource) {
        this.sharedResource = sharedResource;
        synchronized (lock) {
            System.out.println("释放锁。。。" + Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StudyThread studyThread = new StudyThread();
        Thread thread1 = new Thread(studyThread);
        Thread thread2 = new Thread(studyThread);
        Thread thread3 = new Thread(studyThread);
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(2000);
        studyThread.setSharedResource("Hello");
    }
}
