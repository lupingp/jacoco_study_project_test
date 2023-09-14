package com.example.study.project.studyproject.study;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 学习FileUtils工具类
 */
public class StudyFileUtils {

    /**
     * 文件创建和删除
     */
    public static void fileCreatedAndDel() {
        File file = new File("/Users/luping/code/study1.txt");
        try {
            // 创建文件
            FileUtils.touch(file);
        } catch (IOException e) {
            System.out.println("文件创建失败...");
        }
        if (file.isFile()) {
            System.out.println("文件创建成功...");
        }
        // 删除文件
        if (FileUtils.deleteQuietly(file)) {
            System.out.println("删除文件成功...");
        }
    }

    /**
     * 文件复制
     * 文件创建
     */
    public static void copyFile() throws IOException {
        // 文件复制
        File file1 = new File("/Users/luping/code/studyTest/java.txt");
        File file2 = new File("/Users/luping/code/studyTest1/java1.txt");
        // 执行逻辑：将指定目录文件复制到目标的目录中，且目标路径上要指定新的文件名，file1表示指定路径的java.txt是文件，file2表示目标的文件路径java1.txt表示新的文件名，
        // 复制内容包含文件及文件内容
        FileUtils.copyFile(file1, file2);
        // 判断文件内容是否一致
        if (FileUtils.contentEquals(file1, file2)) {
            System.out.println("文件复制成功...");
            FileUtils.deleteQuietly(file2);
        }
        // 将文件复制到指定的目录，弊端是：因为是目录所以无法判断文件内容一致性
        File docs = new File("/Users/luping/code/studyTest2");
        FileUtils.forceMkdir(docs);
        FileUtils.copyFileToDirectory(file1, docs);
        if (docs.exists()) {
            System.out.println("文件复制成功...");
        }
    }

    /**
     * 获取文件大小，千字节和兆字节
     */
    public static void fileSize() throws IOException {
        File file1 = new File("/Users/luping/code/studyTest/java.txt");
        File file2 = new File("/Users/luping/code");
        long fileSize1 = FileUtils.sizeOf(file1);
        long fileSize2 = FileUtils.sizeOfDirectory(file2);

        double file1kb1 = fileSize2 / FileUtils.ONE_KB;
        double file1kb2 = fileSize2 / FileUtils.ONE_MB;
        System.out.println(file1kb1);
        System.out.println(file1kb2);

//        File file1 = new File("/Users/luping/code/studyTest/study.html");
//        FileUtils.touch(file1);
//        URL url = new URL("http://www.something.com");
//        FileUtils.copyURLToFile(url,file1);
//        String content = FileUtils.readFileToString(file1, StandardCharsets.UTF_8.name());
//        System.out.println(content);
    }

    /**
     * 读取文件内容
     *
     * @throws IOException
     */
    public static void readFile() throws IOException {
        File file1 = new File("/Users/luping/code/studyTest/java.txt");
        String content = FileUtils.readFileToString(file1, StandardCharsets.UTF_8.name());
        System.out.println("读取文件内容是：" + content);
        List<String> content1 = FileUtils.readLines(file1, StandardCharsets.UTF_8.name());
        System.out.println("读取文件内容是：" + content1);

    }

    /**
     * 文件写入
     *
     * @throws IOException
     */
    public static void writeFile() throws IOException {
        String string = "Today is a gloomy day.";
        File file1 = new File("/Users/luping/code/studyTest/java.txt");
        FileUtils.writeStringToFile(file1,string);
        List<String> objects = new ArrayList<>();
        objects.add("1111");
        objects.add("2222");
        FileUtils.writeLines(file1,objects);
        List<String> content1 = FileUtils.readLines(file1, StandardCharsets.UTF_8.name());
        System.out.println("读取文件内容是：" + content1);
        String content = FileUtils.readFileToString(file1, StandardCharsets.UTF_8.name());
        System.out.println("读取文件内容是：" + content);
    }

    public static void filePath(){
        // 项目运行时临时路径
        String teamp = FileUtils.getTempDirectoryPath();
        System.out.println("临时路径："+teamp);
        // 系统主路径
        String abPath = FileUtils.getUserDirectoryPath();
        System.out.println("绝对路径："+abPath);
    }

    /**
     * 文件内容清理
     * @throws IOException
     */
    public static void fileClear() throws IOException {
        File file1 = new File("/Users/luping/code/studyTest/");
        FileUtils.cleanDirectory(file1);
    }


    public static void main(String[] args) throws IOException {
//        StudyFileUtils.fileCreatedAndDel();
//        StudyFileUtils.copyFile();
//        StudyFileUtils.fileSize();
//        StudyFileUtils.readFile();
//        StudyFileUtils.writeFile();
//        StudyFileUtils.filePath();
        StudyFileUtils.fileClear();
    }
}
