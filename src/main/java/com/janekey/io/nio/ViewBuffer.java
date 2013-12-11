package com.janekey.io.nio;

import java.nio.ByteBuffer;

/**
 * User: jackeyzheng
 * Date: 13-12-11
 * Time: 下午3:09
 */
public class ViewBuffer {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.asCharBuffer().put("Hello");
        char c;
        while ((c = bb.getChar()) != 0)
            System.out.print(c);
        System.out.println();
        bb.rewind();

        bb.asShortBuffer().put((short) 123);
        System.out.println(bb.getShort());

        bb.asIntBuffer().put(321);
        System.out.println(bb.getInt());

        //...
        System.out.println(0x8FF);
    }

}
