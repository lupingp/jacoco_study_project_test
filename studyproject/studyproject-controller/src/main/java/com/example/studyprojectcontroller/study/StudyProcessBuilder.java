package com.example.studyprojectcontroller.study;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

/**
 * 学习进程管理
 */
public class StudyProcessBuilder {

    /**
     * 构建操作系统命令查看jdk版本
     * @throws IOException
     */
    public static void StudyProces() throws IOException, InterruptedException {
//        ProcessBuilder processBuilder = new ProcessBuilder("java","-version");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash","-c","echo $PATH");
        processBuilder.redirectErrorStream(true);
        processBuilder.inheritIO();
        Process proces = processBuilder.start();
        String result1 = IOUtils.toString(proces.getInputStream());
        int code = proces.waitFor();
        System.out.println("jdk版本："+result1);
        System.out.println("运行结果："+code);
    }

    /**
     * 环境变量
     */
    public static void studyEnv(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        Map<String,String> environment = processBuilder.environment();
        environment.forEach((k,v)-> System.out.println("k："+k+" "+"v："+v));
        processBuilder.environment().put("my_website","luping08");
        System.out.println("新增的环境变量是："+processBuilder.environment().get("my_website"));
        String ss = processBuilder.environment().remove("my_website");
        System.out.println("删除的环境变量是："+ss);
        if (processBuilder.environment().get("my_website") == null){
            System.out.println("删除环境变量成功");
        }
    }

    /**
     * 新增变量 并执行shell命令查看变量
     */
    public static void studyEnvShell() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.environment().put("my_website","luping08");
        processBuilder.command("/bin/bash","-c","echo $my_website");
        processBuilder.redirectErrorStream(true);
        Process proces = processBuilder.start();
        String result = IOUtils.toString(proces.getInputStream());
        System.out.println("执行shell查看环境变量结果："+result);
//        processBuilder.environment().remove("my_website");
    }


    private static String BASE_DIR = "/Users/luping/code";
    /**
     * 修改工作目录
     * @throws IOException
     */
    public static void studyDirectory() throws IOException {
        File file = new File(BASE_DIR,"/test.txt");
        file.createNewFile();
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(BASE_DIR));
        processBuilder.command("pwd");
        processBuilder.command("ls");
        processBuilder.redirectErrorStream(true);
        // 多次执行命令，最后一条命令的日志会把前面都覆盖
//        processBuilder.redirectOutput(file);
        // 追加
        processBuilder.redirectOutput(ProcessBuilder.Redirect.appendTo(file));
        processBuilder.start();
        Files.lines(file.toPath()).forEach(System.out::println);
    }




    public static void main(String[] args) throws IOException, InterruptedException {
        StudyProcessBuilder.StudyProces();
//        StudyProcessBuilder.studyEnv();
//        StudyProcessBuilder.studyEnvShell();
//        StudyProcessBuilder.studyDirectory();


        // var是lombok推广使用，定义为局部变量，通过值确定变量的类型，且这个变量类型不可改变，后面赋值必须使用相同类型
        // 他是一个非final的类型
        // https://projectlombok.org/features/var 官方文档
//        var ll = "12121";
//        ll = "31212";
//        var ls = Arrays.asList("2312222");
//        System.out.println(ll.getClass().getName());
//        System.out.println(ll);
//        System.out.println(ls.getClass().getName());
    }
}
