package com.example.studyprojectcontroller.study;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StudyJsoup {

    public static String HTML_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\">\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\" />\n" +
            "    <link rel=\"stylesheet\" href=\"jacoco-resources/report.css\" type=\"text/css\" />\n" +
            "    <link rel=\"shortcut icon\" href=\"jacoco-resources/report.gif\" type=\"image/gif\" />\n" +
            "    <title>manualDiffCoverageReport</title>\n" +
            "    <script type=\"text/javascript\" src=\"jacoco-resources/sort.js\"></script>\n" +
            "</head>\n" +
            "<body onload=\"initialSort(['breadcrumb', 'coveragetable'])\">\n" +
            "    <div class=\"breadcrumb\" id=\"breadcrumb\"><span class=\"info\"><a href=\"jacoco-sessions.html\" class=\"el_session\">Sessions</a></span><span class=\"el_report\">manualDiffCoverageReport</span></div>\n" +
            "    <h1>manualDiffCoverageReport</h1>\n" +
            "    <table class=\"coverage\" cellspacing=\"0\" id=\"coveragetable\">\n" +
            "        <thead>\n" +
            "            <tr>\n" +
            "                <td class=\"sortable\" id=\"a\" onclick=\"toggleSort(this)\">Element</td>\n" +
            "                <td class=\"down sortable bar\" id=\"b\" onclick=\"toggleSort(this)\">Missed Instructions</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"c\" onclick=\"toggleSort(this)\">Cov.</td>\n" +
            "                <td class=\"sortable bar\" id=\"d\" onclick=\"toggleSort(this)\">Missed Branches</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"e\" onclick=\"toggleSort(this)\">Cov.</td>\n" +
            "                <td class=\"sortable ctr1\" id=\"f\" onclick=\"toggleSort(this)\">Missed</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"g\" onclick=\"toggleSort(this)\">Cxty</td>\n" +
            "                <td class=\"sortable ctr1\" id=\"h\" onclick=\"toggleSort(this)\">Missed</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"i\" onclick=\"toggleSort(this)\">Lines</td>\n" +
            "                <td class=\"sortable ctr1\" id=\"j\" onclick=\"toggleSort(this)\">Missed</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"k\" onclick=\"toggleSort(this)\">Methods</td>\n" +
            "                <td class=\"sortable ctr1\" id=\"l\" onclick=\"toggleSort(this)\">Missed</td>\n" +
            "                <td class=\"sortable ctr2\" id=\"m\" onclick=\"toggleSort(this)\">Classes</td>\n" +
            "            </tr>\n" +
            "        </thead>\n" +
            "        <tbody>\n" +
            "        </tbody>\n" +
            "<tfoot></tfoot>" +
            "    </table>\n" +
            "    <div class=\"footer\"><span class=\"right\">Created with <a href=\"http://www.jacoco.org/jacoco\">JaCoCo</a> 1.0.1.201909190214</span></div>\n" +
            "</body>\n" +
            "</html>";

    public static void jsoupStudy01() {
//        String html = "<html><head><title>First parse</title></head>"
//                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        // document代表的是html文档
        try {
            Document parse = Jsoup.parse(HTML_TEMPLATE);
            Elements element = parse.getElementsByTag("table");
            Document index = Jsoup.parse(new File("/Users/luping/app/mcs_jacoco/clonecode/101000000210018/feature_newtest02/studyproject/jacocoreport/studyproject-service/index.html"), "UTF-8", "");
            // .html是返回元素内的html信息
            System.out.println();
//            element.first().getElementsByTag("tfoot").append(index.getElementsByTag("tbody").first().html());
//            for (Element ele:index.getElementsByTag("tbody")){
//                for (Element ele1:ele.getElementsByTag("tr")){
////                    System.out.println(ele1);
//                    element.first().getElementsByTag("tfoot").first().append(ele1.html());
//                }
//            }
            System.out.println(index.getElementsByTag("tfoot"));
            System.out.println("------------");
            System.out.println(index.getElementsByTag("tfoot").first().child(0).child(1).attr("class"));
            System.out.println("------------");
            System.out.println(index.getElementsByTag("tfoot").first());
//            System.out.println(parse);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        System.out.println("获取头节点数据："+parse.getElementsByTag("head").first());
//        System.out.println("获取标题数据："+parse.title());
//        System.out.println("获取body数据------------------------------");
//        System.out.println("获取body数据："+parse.body());
//        System.out.println("获取href标签数据："+parse.getElementsByAttribute("href").first());
    }

    public static void jsoupStudy02() throws IOException {
        String url = "https://jsoup.org/cookbook/input/load-document-from-url";
        // document代表的是html文档
        // 请求网页获取Document数据
        Document parse = Jsoup.connect(url).get();
        System.out.println(parse);
        System.out.println(parse.title());
    }

    public static void main(String[] args) throws IOException {
        StudyJsoup.jsoupStudy01();
//        StudyJsoup.jsoupStudy02();
    }
}
