package com.example.studyprojectcontroller.study;

/**
 * @author xiaoxi666
 * @date 2021-02-15 17:13
 * 我是 Javadoc 注释
 */
public class TestInput {

    public static void someMethod(String param1,// 我是单行注释 param1

                                  String param2
                                  // 我是单行注释 String param3,
                            /* 我是块注释 String param4,
                                   String param5,
                                   String param6 */
            /* 我是块注释 String param4 */
    )
    {
        // 我是单行注释
        int a = 1;
        /* 我是块注释，注意我和Javadoc注释的区别，我只有一个星号 */
        int b = 2;
        /*
         * 我是块注释
         */
        int c = 3;
        String s1 = "// 我是字符串中的内容，不是注释";
        String s2 = "/* 我是字符串中的内容，不是注释 */";
        String s3 = "/** 我是字符串中的内容，不是注释 */";
    }

    public static void Test1(Long name){}
    public static void Test2(Integer in){}
    private  void Test3(int in){}
    private String Test4(){
        return "";
    }
}
