package com.janekey.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: Administrator
 * Date: 13-7-12
 * Time: 上午12:20
 */
public class TalkClient {

    public static void main(String[] args) {
        try {
            //向目标主机端口发出客户请求
            Socket socket = new Socket("127.0.0.1", 9090);
            String hello = "Hello, I'm client!!!";

            // 获取Server的输出流，即Client的输入流
            BufferedReader serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 返回给Client的输出流
            PrintWriter toServer = new PrintWriter(socket.getOutputStream());
            BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in));

            toServer.println(hello);
            toServer.flush();// 刷新输出流，使Client马上收到
            System.out.println("Me : " + hello);

            String serverString = serverOutput.readLine();
            // 从服务端读入的字符流
            while (!serverString.equals("bye")) {
                System.out.println("Server: " + serverString);
                System.out.print("Me : ");
                String toServerString = systemInput.readLine();
                toServer.println(toServerString);
                toServer.flush();// 刷新输出流，使Client马上收到

                serverString = serverOutput.readLine();
            }

            serverOutput.close();
            toServer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
