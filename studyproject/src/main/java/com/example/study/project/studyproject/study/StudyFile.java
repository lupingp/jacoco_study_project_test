package com.example.study.project.studyproject.study;

import java.io.File;
import java.io.IOException;

public class StudyFile {

    /**
     * 学习File 创建目录
     */
    public static void studyFiles(){
        String path = "/Users/luping/code/studyjava2";
        File file = new File(path);
        if (!file.exists()){
            System.out.println("文件路径不存在...");
            System.out.println("开始创建");
            file.mkdirs();
            try {
                String path1 = "/Users/luping/code/studyjava2/java.txt";
                File path2 = new File(path1);
                path2.createNewFile();
            }catch (IOException ioe){
                System.out.println("文件创建失败...");
            }
            System.out.println("文件是否可读="+file.canRead());
            System.out.println("文件是否可写="+file.canWrite());
            System.out.println("文件是否存在="+file.exists());
            System.out.println("文件是否为目录="+file.isDirectory());
            System.out.println("文件是否隐藏="+file.isHidden());
            System.out.println("文件路径="+file.getPath());
            System.out.println("文件绝对路径="+file.getAbsolutePath());
            System.out.println("文件父目录="+file.getParent());
            System.out.println("文件对象最后的名字="+file.getName());
        }
        if (file.isDirectory()){
            System.out.println("目录创建成功...");
        }
    }

    /**
     * File学习
     * 相对路径
     * 绝对路径
     */
    public static void studyFilesTwo(){
        File file = new File("java");
        // 绝对路径
        System.out.println(file.getAbsoluteFile());
        // /Users/luping/code/studyproject/java
    }

    public static void main(String[] args) {
        StudyFile.studyFiles();
        StudyFile.studyFilesTwo();
    }
}
