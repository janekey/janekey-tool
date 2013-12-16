package com.janekey.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * User: jackeyzheng
 * Date: 13-12-16
 * Time: 下午4:17
 */
public class FileChannelDemo {
    static FileChannel fc;
    static String file = "e:/test.txt";
    public static void main(String[] args) throws IOException{
        writeDemo();
        readDemo();
    }

    private static void writeDemo() throws IOException{
        //write file
        fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("So".getBytes()));
        fc.close();

        //add to the end
//        fc = new RandomAccessFile(file, "rw").getChannel();
//        fc.position(fc.size());
//        fc.write(ByteBuffer.wrap("more".getBytes()));
//        fc.close();
    }

    private static void readDemo() throws IOException{
        //read
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = fc.read(buffer);
        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining())
                System.out.print((char)buffer.get());

    //        buffer.flip();
    //        System.out.println(buffer.asCharBuffer());

            buffer.clear();
            bytesRead = fc.read(buffer);
        }
    }
}
