package com.janekey.net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: jackeyzheng
 * Date: 13-12-12
 * Time: 上午11:30
 */
public class HTTPTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://book.qq.com");
            InputStream is = url.openConnection().getInputStream();
            byte[] buffer = new byte[is.available()];
            if (is.read(buffer) != -1) {
                for (byte b : buffer)
                    System.out.print((char) b);
            }
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
