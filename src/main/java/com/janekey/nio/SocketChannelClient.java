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

        ByteBuffer buffer = ByteBuffer.allocate(30);
        buffer.put("hello I'm client".getBytes());

        buffer.flip();
        channel.write(buffer);

        buffer.clear();
        int ret = channel.read(buffer);
        if (ret == -1) {
            System.out.println("no data");
        } else {
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.print((char) buffer.get());
            System.out.println();
        }

        channel.close();
    }

}
