package com.example.studyprojectcontroller.study;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudyHttpClent {

    private String message = "收到撒打算打算";

//    public StudyHttpClent() {
//        System.out.println("调用了message");
//        this.message = "message";
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 不带参数的GET请求
     */
    public static void httpGet() {
        // 创建客户端连接
        CloseableHttpClient closeableHt = HttpClients.createDefault();
        String uri = "http://www.kuaidi100.com/query?type=yuantong&postid=11111111111";
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHt.execute(httpGet);
        } catch (ClientProtocolException li) {
            li.printStackTrace();
        } catch (IOException io) {
            System.out.println("io连接异常...");
        }
        HttpEntity entity = httpResponse.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity, StandardCharsets.UTF_8.name());
        } catch (Exception ex) {
            System.out.println("字符串解析异常...");
        }
        System.out.println("打印结果：" + result.toString());
        try {
            httpResponse.close();
            closeableHt.close();
        }catch (IOException ioe){
            System.out.println("关闭异常...");
        }
    }

    /**
     * 带参数的Get请求
     * 设置响应头部
     */
    public static void httpGetheader() throws URISyntaxException, IOException {
        String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "&"));
        params.add(new BasicNameValuePair("age", "18"));
        URI uri = new URIBuilder("http://www.kuaidi100.com/query")
                .addParameter("type","yuantong")
                .addParameter("postid","11111111111")
                .build();
        System.out.println("URL是："+uri.toString());
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent",UserAgent);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println("响应状态："+response.getStatusLine().getStatusCode());
        System.out.println("响应状态："+response.getStatusLine().getProtocolVersion());
        System.out.println("响应状态："+response.getStatusLine().getReasonPhrase());
        System.out.println("响应状态："+response.getStatusLine().toString());
        HttpEntity entity = response.getEntity();
        System.out.println("响应类型："+entity.getContentType());
        String result = EntityUtils.toString(entity,StandardCharsets.UTF_8.name());
        System.out.println("打印结果：" + result.toString());
        response.close();
        httpClient.close();

    }

    public static void main(String[] args) throws URISyntaxException, IOException {
//        StudyHttpClent.httpGet();
        StudyHttpClent.httpGetheader();
    }
}
