package com.janekey.net.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * User: jackeyzheng
 * Date: 13-12-23
 * Time: 下午3:21
 */
public class HTTPSTest {

    static String referer = "https://mp.weixin.qq.com/";

    static List<String> cookieList;

    public static void main(String[] args) throws Exception {

        login();

//        String urlString2 = "https://mp.weixin.qq.com/cgi-bin/contactmanage?t=user/index&pagesize=10&pageidx=0&type=0&token=1922582543&lang=zh_CN";
//        get(urlString2, referer);

        String urlString = "https://mp.weixin.qq.com/cgi-bin/masssend";
        String ref = "https://mp.weixin.qq.com/cgi-bin/masssendpage?t=mass/send&token=1922582543&lang=zh_CN";
        String data = "type=1&content=测试&sex=0&groupid=-1&synctxweibo=0&synctxnews=0&country=&province=&city=&imgcode=&token=1922582543&lang=zh_CN&random=0.527283979812637&f=json&ajax=1&t=ajax-response";
        post(urlString, ref, data);
    }

    static void get(String urlString, String referer) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.setRequestProperty("Referer", referer);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        StringBuilder cookie = new StringBuilder();
        Iterator<String> cookieIt = cookieList.iterator();
        while (cookieIt.hasNext()) {
            cookie.append(cookieIt.next());
            if (cookieIt.hasNext())
                cookie.append("; ");
        }
        connection.setRequestProperty("Cookie", cookie.toString());

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        System.out.println("===================Connect Result=======================");
        while ((line = br.readLine()) != null) {
            System.out.println(line.replace("    ", "\n"));
        }
        is.close();
        System.out.println("===================Connect Result=======================");
    }

    static void login() throws Exception {
        String loginUrl = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";
        String data = "username=312707402%40qq.com&pwd=1e589489b523150b185e5d46dc2e69bc&imgcode=&f=json";

        URL url = new URL(loginUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);//设置输出模式
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.setRequestProperty("Referer", referer);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        OutputStream outputStream = connection.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(data);
        writer.close();

        Map<String,List<String>> map = connection.getHeaderFields();
        cookieList = map.get("Set-Cookie");

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        System.out.println("===================Login Result=======================");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        is.close();
        System.out.println("===================Login Result=======================");
    }

    static void post(String urlString, String ref, String data) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);//设置输出模式
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        connection.setRequestProperty("Referer", ref);
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");

        OutputStream outputStream = connection.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(data);
        writer.close();

        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        System.out.println("===================Post Result=======================");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        is.close();
        System.out.println("===================Post Result=======================");
    }
}
