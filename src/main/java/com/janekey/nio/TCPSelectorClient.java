package com.janekey.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * User: jackeyzheng
 * Date: 13-12-17
 * Time: 上午11:43
 */
public class TCPSelectorClient {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();//获取Socket通道
        channel.configureBlocking(false);//设为非阻塞
        channel.connect(new InetSocketAddress("localhost", 8888));//在获取注册的事件后，channel.finishConnect()才能完成连接

        Selector selector = Selector.open();//获得通道的多路复用器(通道管理器)

        channel.register(selector, SelectionKey.OP_CONNECT);

        boolean done = false, write = false;
        while (!done) {
            int readChannels = selector.select(200);//非阻塞，通过上面的while轮询
            if (readChannels == 0) {
                System.out.println("continue");
                continue;
            }

            Iterator keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                keyIterator.remove();

                if (key.isConnectable() && !channel.isConnected()) {
                    SocketChannel c = (SocketChannel) key.channel();
                    if (c.isConnectionPending()) c.finishConnect();

                    c.register(selector, SelectionKey.OP_WRITE);//注册为写事件，准备向服务端发送数据
                } else if (key.isWritable() && !write) {
                    SocketChannel c = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("Hi, I'm client".getBytes());
                    buffer.flip();
                    c.write(buffer);
                    write = true;

                    c.register(selector, SelectionKey.OP_READ);//注册为读事件，准备从服务端接收数据
                } else if (key.isReadable() && write) {
                    SocketChannel c = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int ret = c.read(buffer);
                    if (ret == -1) {
                        System.out.println("no data");
                    } else {
                        buffer.flip();
                        while (buffer.hasRemaining())
                            System.out.print((char) buffer.get());
                        System.out.println();
                    }
                    c.close();
                    done = true;
                }
            }
        }
    }

}
