package com.example.study.project.studyproject.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StudyJsoup {

    private static final String htmlPath = "/Users/luping/Downloads/jacoco-0.8.7/lib/jacoco_01/index.html";
    private static final String USER_HTML = "/Users/luping/Desktop/index.html";

    public static void jsoupStudy() throws Exception {
        File file = new File(htmlPath);
        Document parse = Jsoup.parse(file, StandardCharsets.UTF_8.name());
        System.out.println("HTML："+parse);
        Elements element = parse.getElementById("coveragetable").getElementsByTag("tfoot").first().getElementsByClass("bar");
        System.out.println("element："+element);
        System.out.println("element："+ Arrays.stream(element.get(1).text().split(" of ")).collect(Collectors.toList()));
        Elements elementsctr1 = parse.getElementById("coveragetable").getElementsByTag("tfoot").first().getElementsByClass("ctr1");
        System.out.println("elementsctr1："+elementsctr1);
        System.out.println("elementsctr1："+elementsctr1.get(1).text().replace(",", ""));
        Elements elementsctr2 = parse.getElementById("coveragetable").getElementsByTag("tfoot").first().getElementsByClass("ctr2");
        System.out.println("elementsctr2："+elementsctr2);
    }


    public static void jsoupStudy2() throws Exception {
        File file = new File(htmlPath);
        File file2 = new File(USER_HTML);
        Document parse = Jsoup.parse(file, StandardCharsets.UTF_8.name());
        Document parse2 = Jsoup.parse(file2, StandardCharsets.UTF_8.name());
        Elements element = parse.getElementsByTag("tbody").first().getElementsByTag("tr");
        System.out.println("child:"+Arrays.stream(parse.getElementsByTag("tfoot").first().child(0).text().split(" ")).collect(Collectors.toList()));
//        doc.getElementsByTag("tfoot").first().child(0).text().split(" ");
//        System.out.println("element："+element);
//        for (Element e:element) {
//            parse2.getElementsByTag("tbody").first().append(e.html());
//            System.out.println("返回element："+e.html());
//        }
//        System.out.println(parse2);
    }


    public static void jsoupStudy3() throws Exception {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
    }

    public static void main(String[] args) throws Exception {
//        StudyJsoup.jsoupStudy();
//        StudyJsoup.jsoupStudy2();
        StudyJsoup.jsoupStudy3();
    }
}
