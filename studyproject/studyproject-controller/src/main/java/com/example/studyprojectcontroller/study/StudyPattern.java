package com.example.studyprojectcontroller.study;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 学习正则表达式
 */
public class StudyPattern {

    /**
     * 学习正则表达式
     */
    public static void studyPattern() {
//        Pattern parRegex = Pattern.compile("bc*d");
//        Matcher matcher = parRegex.matcher("bccccd");
//        boolean b = matcher.matches();
//        System.out.println(b);

        Pattern pattern = Pattern.compile("Java");
        System.out.println(pattern.pattern());

        String test = "123Java456Java789Java";
        String[] result = pattern.split(test, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    /**
     * 全量匹配
     */
    public static void studyMathers() {
        String java1 = "Java";
        String java2 = "Javate";

        boolean pattern1 = Pattern.matches("Java", java1);
        boolean pattern2 = Pattern.matches("java", java2);

        System.out.println(pattern1);
        System.out.println(pattern2);
    }

    /**
     * Matcher用法
     */
    public static void studyMatcher() {
        Pattern pattern = Pattern.compile("Java");
        String test = "123Java456Java789Java";

        String test1 = "Java";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());


        String test2 = "Java1234";
        String test3 = "1234Java";
        matcher = pattern.matcher(test2);
        System.out.println(matcher.lookingAt());
        matcher = pattern.matcher(test3);
        System.out.println(matcher.lookingAt());

        System.out.println("使用find进行匹配");
        matcher = pattern.matcher(test1);
        System.out.println(matcher.find());
        matcher = pattern.matcher(test3);
        System.out.println(matcher.find());
        matcher = pattern.matcher(test2);
        System.out.println(matcher.find(3));
    }

    /**
     * 学习分组
     */
    public static void matcher() {
        Pattern pattern = Pattern.compile("java");
        Matcher matcher = pattern.matcher("12java自由java之路");
        int groupCount = matcher.groupCount();
        System.out.println(groupCount);
        groupCount = matcher.groupCount();
        System.out.println(groupCount);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            System.out.println("start:end:group-->" + start + ":" + end + ":" + group);
        }
    }

    /**
     * 组数
     */
    public static void matchers() {
//        Pattern pattern = Pattern.compile("(?<p1>java)(python)");
//        Matcher matcher1 = pattern.matcher("java自由java之路javapython自由之路python");
//        System.out.println(matcher1.matches());
//        System.out.println(matcher1.lookingAt());
//        int count = matcher1.groupCount();
//        System.out.println("组数："+count);
//        while (matcher1.find()){
//            for (int i = 0; i < count; i++) {
//                int start = matcher1.start(i);
//                int end = matcher1.end(i);
//                String group = matcher1.group(i);
//                System.out.println("start:end:group-->" + start + ":" + end + ":" + group);
//            }
//            System.out.println(matcher1.group("p1"));
//        }

        Pattern pattern1 = Pattern.compile("Java");
        Matcher matcher = pattern1.matcher("Java1234");
        //返回true
//        System.out.println(matcher.find());
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            System.out.println(matcher.group());
            matcher.appendReplacement(sb, matcher.group());
        }
        System.out.println(sb);
    }

    public static void test() {
        String line = "/Users/luping/code/studyproject/pom.xml";
        ArrayList<String> validModuleList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(line));
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim());
            }
            String pomStr = sb.toString();
            System.out.println("POM文件内容是：" + pomStr);
            String moduleregex = "<modules>.*?</modules>";
            Pattern pattern = Pattern.compile(moduleregex);
            Matcher matcher = pattern.matcher(pomStr);
            String modules;
            if (matcher.find()){
                modules = matcher.group();
                System.out.println("modules组有："+modules);
                modules = modules.replaceAll("<!--.*?<module>.*?</module>.*?-->", ",");
                System.out.println("modules匹配有："+modules);
                modules = modules.replaceAll("</?modules?>", ",");
                System.out.println("modules匹配有："+modules);
                String[] module = modules.split(",");
                for (String m : module) {
                    if (!m.equals("")) {
                        validModuleList.add(m);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("module列表："+validModuleList);
    }

    public static void main(String[] args) {
//        StudyPattern.studyPattern();
//        StudyPattern.studyMathers();
//        StudyPattern.studyMatcher();
//        StudyPattern.matcher();
//        StudyPattern.matchers();
        StudyPattern.test();
        System.out.println(StandardCharsets.UTF_8.name());
    }
}
