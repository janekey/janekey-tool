package com.janekey.net.url;

import javax.net.ssl.*;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * User: jackeyzheng
 * Date: 13-12-23
 * Time: 下午3:21
 */
public class HTTPSTest {

    public static void main(String[] args) throws Exception {
        TrustManager[] tm = {new MyX509TrustManager()};
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new SecureRandom());

        SSLSocketFactory ssf = sslContext.getSocketFactory();

        URL url = new URL("http://www.qq.com");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(ssf);
        connection.setDoOutput(true);

        connection.connect();
    }

    public static class MyX509TrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

}
