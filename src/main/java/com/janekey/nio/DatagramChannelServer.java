package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 上午9:36
 */
public class DatagramChannelServer {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(8888));

        //receive
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        System.out.println("receiving");
        SocketAddress clientAddress = channel.receive(buffer);

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        //send
        buffer.clear();
        buffer.put("I'm server".getBytes());
        buffer.flip();
        channel.send(buffer, clientAddress);

        channel.close();
    }

}
