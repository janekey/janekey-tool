package com.janekey.serialize;

import java.io.*;

/**
 * User: jackeyzheng
 * Date: 14-12-7
 * Time: 下午1:12
 */
public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("E:/person.out");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//        Person person = new Person("张三", 20, "男");
        Person2 person = new Person2("张三", 20, "男");
        out.writeObject(person);
        out.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = input.readObject();//读取的时候没有调用构造器, Classpath中必须含有Person类
        input.close();
        System.out.println(newPerson);

    }

}
