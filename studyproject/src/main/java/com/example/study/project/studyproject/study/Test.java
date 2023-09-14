package com.example.study.project.studyproject.study;

/**
 * @author luping
 * @date 2023/9/4 22:57
 */
public class Test implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is Created");
    }

    public static void main(String[] args) throws InterruptedException {
//        Test test = new Test();
//        Thread thread = new Thread(test,"试试水");
//        thread.setPriority(Thread.MAX_PRIORITY);
//        thread.start();
//        Thread.sleep(1000);
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(thread.getName());

        String ss = "dsadsadas1dsadas";
        System.out.println(ss.indexOf("1"));

    }
}
