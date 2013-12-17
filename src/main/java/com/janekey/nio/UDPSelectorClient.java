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
 * Time: 下午4:23
 */
public class UDPSelectorClient {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        DatagramChannel channel = DatagramChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8888));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        boolean done = false, write = false;
        while (!done) {
            int count = selector.select(200);
            if (count == 0) {
                System.out.println("select zero");
                return;
            }

            Iterator iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();

                if (key.isWritable() && !write) {
                    channel = (DatagramChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("I'm client".getBytes());
                    buffer.flip();
                    channel.write(buffer);
//                    channel.send(buffer, new InetSocketAddress("localhost", 8888));
                    write = true;
                }
                if (key.isReadable() && write) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int ret = channel.read(buffer);
//                    channel.receive(buffer);
//                    int ret = 1;
                    if (ret == -1) {
                        System.out.println("server no data");
                    } else {
                        buffer.flip();
                        while (buffer.hasRemaining())
                            System.out.print((char) buffer.get());
                        System.out.println();
                    }
                    channel.close();
                    done = true;
                }

            }
        }
    }

}
