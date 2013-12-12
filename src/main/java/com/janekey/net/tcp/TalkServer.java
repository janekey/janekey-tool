package com.janekey.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: Administrator
 * Date: 13-7-12
 * Time: 上午12:07
 */
public class TalkServer {

    public static void main(String[] args) {
        try {
            // 在端口9090上监听客户请求
            ServerSocket server = new ServerSocket(9090);
            Socket socket = null;

            // 使用accept方法阻塞等待客户请求，有客户请求产生一个socket对象并继续执行
            socket = server.accept();
            String hello = "Hello, I'm server!!!";

            // 获取Client的输出流，即Server的输入流
            BufferedReader clientOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 返回给Client的输出流
            PrintWriter toClient = new PrintWriter(socket.getOutputStream());
            BufferedReader systemInput = new BufferedReader(new InputStreamReader(System.in));

            toClient.println(hello);
            toClient.flush();// 刷新输出流，使Client马上收到
            System.out.println("Me : " + hello);

            String clientString = clientOutput.readLine();
            // 从客户端读入的字符流
            while (!clientString.equals("bye")) {
                System.out.println("Client: " + clientString);
                System.out.print("Me : ");
                String toClientString = systemInput.readLine();
                toClient.println(toClientString);
                toClient.flush();// 刷新输出流，使Client马上收到

                clientString = clientOutput.readLine();
            }

            toClient.close();
            clientOutput.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
