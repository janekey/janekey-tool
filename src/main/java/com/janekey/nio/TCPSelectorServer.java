package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 上午11:18
 */
public class TCPSelectorServer {

    public static void main(String[] args) throws IOException{
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(8888));

        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int readChannels = selector.select();
            if (readChannels == 0) {
                System.out.println("continue");
                continue;
            }
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if (key.isAcceptable()) {   //Accept
                    System.out.println("accept");
                    SocketChannel client = channel.accept();
                    client.configureBlocking(false);
                    client.register(key.selector(), SelectionKey.OP_READ);
                    System.out.println("accept2");
                } else if (key.isConnectable()) {
                    System.out.println("connect");
                } else if (key.isReadable()) {
                    System.out.println("readable");
                    SocketChannel client = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.clear();

                    //receive
                    int ret = client.read(buffer);
                    if (ret == -1) {
                        System.out.println("no data");
                        client.close();
                    } else {
                        buffer.flip();
                        while (buffer.hasRemaining())
                            System.out.print((char) buffer.get());
                        System.out.println();

                        //send
                        buffer.clear();
                        buffer.put("i'm server".getBytes());
                        buffer.flip();
                        client.write(buffer);

//                        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }
                } else if (key.isWritable()) {
                    System.out.println("write");
                }
                keyIterator.remove();
            }
        }
    }

}
