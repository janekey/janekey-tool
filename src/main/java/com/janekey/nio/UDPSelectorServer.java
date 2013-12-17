package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 下午3:44
 */
public class UDPSelectorServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(8888));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);

        while (true) {
            int count = selector.select();
            if (count == 0) {
                System.out.println("select zero");
                continue;
            }

            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();

                 if (key.isReadable()) {
                     channel = (DatagramChannel) key.channel();
                     ByteBuffer buffer = ByteBuffer.allocate(1024);
                     SocketAddress clientAddress = channel.receive(buffer);
                     buffer.flip();

                     while (buffer.hasRemaining())
                         System.out.print((char) buffer.get());
                     System.out.println();

                     buffer.clear();
                     buffer.put("i'm server".getBytes());
                     buffer.flip();
                     channel.send(buffer, clientAddress);
                 }
            }
        }
    }

}
