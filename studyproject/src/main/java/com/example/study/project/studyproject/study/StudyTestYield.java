package com.example.study.project.studyproject.study;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author luping
 * @date 2023/9/2 17:21
 */
public class StudyTestYield {

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread1 = new MyThread("张三");
//        MyThread myThread2 = new MyThread("李四");
//        myThread1.start();
////        myThread1.interrupt();
//        myThread1.join();
//        myThread2.start();

        String[] compileCmd = new String[]{"cd " + "sada/sadsa/sadsa" + "&&mvn clean compile " +
                (StringUtils.isEmpty("sadasdsa") ? "" : "-P=" + "sdasdsa") + ">>" + "logFile/sdsd/dsds"};
        System.out.println(Arrays.stream(compileCmd).collect(Collectors.toList()));


    }

    private static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                if (i % 2 == 0){
//                    Thread.yield();
//
//                }
                System.out.println("打印线程：" + Thread.currentThread().getName() + "  " + "打印次数：" + i + " " + "状态：" + Thread.currentThread().getState());
            }
        }
    }
}
