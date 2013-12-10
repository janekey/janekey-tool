package com.janekey.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * User: jackeyzheng
 * Date: 13-11-28
 * Time: 下午6:09
 */
public class UDPClient {

    public static void main(String[] args) {
        String msg = "Hello Server";
        byte[] buf = msg.getBytes();
        try {
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8888);

            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] backBuf = new byte[1024];
            DatagramPacket backPacket = new DatagramPacket(backBuf, backBuf.length);
            socket.receive(backPacket);

            String backMsg = new String(backBuf, 0, backPacket.getLength());
            System.out.println("server message:" + backMsg);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
