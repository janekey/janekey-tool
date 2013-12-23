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
        ServerSocketChannel channel = ServerSocketChannel.open();//获取ServerSocket通道
        channel.socket().bind(new InetSocketAddress(8888));
        channel.configureBlocking(false);//设置为非阻塞

        Selector selector = Selector.open();//获得通道的多路复用器(通道管理器)

        channel.register(selector, SelectionKey.OP_ACCEPT);//将通道和selector绑定，并为该通道注册事件
        while (true) {
            int readChannels = selector.select();//注册的通道事件准备就绪，放方法阻塞
            if (readChannels == 0) {
                continue;
            }

            Iterator keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                keyIterator.remove();

                if (key.isAcceptable()) {   //Accept
                    SocketChannel client = channel.accept();//获得客户端连接的通道
                    client.configureBlocking(false);
                    client.register(key.selector(), SelectionKey.OP_READ);//为了接收客户端的信息，将通道注册为读事件
                } else if (key.isConnectable()) {
                    System.out.println("connect");
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //receive
                    int ret = client.read(buffer);
                    if (ret == -1) {
                        System.out.println("no data");
                        client.close();
                    } else {
                        System.out.print("receive client message:");
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
                    client.close();
                } else if (key.isWritable()) {
                    System.out.println("write");
                }
            }
        }
    }

}
