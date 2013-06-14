package com.janekey.datastructure.test;

import com.janekey.datastructure.tree.RBTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-5-23
 * Time: 下午3:43
 */
public class TreeTest {

//    @Test
    public void rbTest() {
        int size = 10;
        int[] a = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++)
            a[i] = r.nextInt(100);

        RBTree tree = new RBTree();
        System.out.println(Arrays.toString(a));
        tree.create(a);

        tree.inorder();


    }

}
