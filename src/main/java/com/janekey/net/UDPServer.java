package com.janekey.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * User: jackeyzheng
 * Date: 13-11-28
 * Time: 下午3:54
 */
public class UDPServer {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888, InetAddress.getLocalHost());//数据套接字

            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);//数据报包

            while (true) {
                System.out.println("waiting...");
                socket.receive(packet);//接收数据

                String getMsg = new String(buf, 0, packet.getLength());
                System.out.println("client message:" + getMsg);

                InetAddress clientAddress = packet.getAddress();//客户端地址
                String feedback = "received";
                byte[] backBuf = feedback.getBytes();
                DatagramPacket feedbackPacket = new DatagramPacket(backBuf, backBuf.length, packet.getAddress(), packet.getPort());
                socket.send(feedbackPacket);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
