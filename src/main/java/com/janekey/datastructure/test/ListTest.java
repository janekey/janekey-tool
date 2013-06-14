package com.janekey.datastructure.test;

import com.janekey.datastructure.list.ArrayList;
import com.janekey.datastructure.list.LinkedList;
import org.junit.Test;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-6-14
 * Time: 下午4:48
 */
public class ListTest {
    Random r = new Random();
//    @Test
    public void arrayListTest() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i, r.nextInt(100));
            System.out.println(arrayList.toString());
        }
        System.out.println(arrayList.get(1));
        arrayList.set(1, 4);
        System.out.println(arrayList);
        arrayList.remove(9);
        System.out.println(arrayList);
    }

    @Test
    public void linkedListTest() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, r.nextInt(100));
            System.out.println(linkedList);
        }
        linkedList.remove(9);
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
        linkedList.set(2, 1);
        System.out.println(linkedList);
    }

}
