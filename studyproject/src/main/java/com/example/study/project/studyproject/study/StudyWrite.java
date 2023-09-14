package com.example.study.project.studyproject.study;

import java.io.*;
import java.util.Objects;

public class StudyWrite {

    /**
     * 创建字符输出流
     */
    public static void studyWrite() {
        String path = "/Users/luping/code/test.txt";
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("创建文件失败...失败原因是：" + e.getMessage());
        }
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write("我是好人。。1111。");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("写入文件失败...失败原因是：" + e.getMessage());
        }
        System.out.println("写入文件成功...");
    }

    public static void studyReader() {
        String path = "/Users/luping/code/test.txt";
        try {
            FileReader fileReader = new FileReader(path);
            while (fileReader.read() != -1) {
                char c = (char)fileReader.read();
                System.out.println(c);;
            }
        } catch (IOException e) {
            System.out.println("读取文件失败...失败原因是：" + e.getMessage());
        }
    }

    /**
     * 读取字符流
     */
    public static void studyBufferedReader() {
        String path = "/Users/luping/code/test.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException ioe) {
            System.out.println("读取字符流失败...失败原因是：" + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
//        StudyWrite.studyWrite();
        StudyWrite.studyReader();
//        StudyWrite.studyBufferedReader();
    }
}
