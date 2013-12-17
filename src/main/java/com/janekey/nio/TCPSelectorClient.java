package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 上午11:43
 */
public class TCPSelectorClient {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("localhost", 8888));

        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE | SelectionKey.OP_READ);

        boolean done = false, write = false;
        while (!done) {
            int readChannels = selector.select(200);
            if (readChannels == 0) {
                System.out.println("continue");
                continue;
            }

            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                keyIterator.remove();

                if (key.isConnectable() && !channel.isConnected()) {
//                    boolean success =
//                    if (!success) channel.finishConnect();
                }
                if (key.isWritable() && !write) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("I'm client".getBytes());
                    buffer.flip();
                    channel.write(buffer);
                    write = true;
                }
                if (key.isReadable() && write) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int ret = channel.read(buffer);
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

//                if (key.isAcceptable()) {
//                    System.out.println("accept");
//                } else if (key.isConnectable()) {
//                    System.out.println("connect");
//                } else if (key.isReadable()) {
//                    System.out.println("read");
//                } else if (key.isWritable()) {
//                    channel = (SocketChannel) key.channel();
//
//                    //write
//                    ByteBuffer buffer = ByteBuffer.allocate(1024);
//                    buffer.put("I'm client".getBytes());
//                    buffer.flip();
//                    channel.write(buffer);
//
//                    key.interestOps(SelectionKey.OP_READ);
//                }
            }
        }
    }

}
