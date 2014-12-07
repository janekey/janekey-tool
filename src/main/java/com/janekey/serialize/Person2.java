package com.janekey.serialize;

import java.io.*;

/**
 * User: jackeyzheng
 * Date: 14-12-7
 * Time: 下午2:49
 */
public class Person2 implements Externalizable {

    private String name;
    private int age;
    private String gender;

    public Person2(String name, int age, String gender) {
        System.out.println("Person2(...)");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person2() {
        System.out.println("Person2()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeObject(name);
//        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        name = (String) in.readObject();
//        age = in.readInt();
    }
}
