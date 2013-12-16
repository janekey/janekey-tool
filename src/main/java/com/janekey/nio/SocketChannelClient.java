package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * User: jackeyzheng
 * Date: 13-12-16
 * Time: 下午5:11
 */
public class SocketChannelClient {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8888));

        ByteBuffer buffer = ByteBuffer.wrap("hello jackey1".getBytes());

        channel.write(buffer);

        channel.close();
    }

}
