package com.janekey.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 * User: jackeyzheng
 * Date: 13-12-11
 * Time: 上午11:19
 */
public class GetChannel {
    static FileChannel fc;
    public static void main(String[] args) throws Exception {
        String file = "e:/test.txt";
        //write file
        fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("So".getBytes()));
        fc.close();

        //add to the end
        fc = new RandomAccessFile(file, "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("more".getBytes()));
        fc.close();

        //read file
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining())
            System.out.print((char)buffer.get());

        System.out.println("=");
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

    }

}
