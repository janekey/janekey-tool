package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 上午9:50
 */
public class DatagramChannelClient {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8888));

        //send
        ByteBuffer buffer = ByteBuffer.wrap("hello I'm client".getBytes());
        channel.write(buffer);

        //receive
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
