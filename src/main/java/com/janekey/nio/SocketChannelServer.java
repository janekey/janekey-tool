package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * User: jackeyzheng
 * Date: 13-12-16
 * Time: 下午5:07
 */
public class SocketChannelServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
//        serverSocketChannel.configureBlocking(false);//no-block

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                ByteBuffer buffer = ByteBuffer.allocate(30);
                int ret = socketChannel.read(buffer);

                if (ret == -1) {
                    socketChannel.close();
                    System.out.println("no data");
                } else {
                    buffer.flip();
                    while (buffer.hasRemaining())
                        System.out.print((char) buffer.get());
                    System.out.println();
                }
                socketChannel.close();
            }

        }

    }

}
