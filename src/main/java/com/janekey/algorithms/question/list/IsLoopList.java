package com.janekey.algorithms.question.list;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 上午11:55
 */
public class IsLoopList {

    //判断链表是否循环
    public static boolean isLoop(Entry head) {
        if (head == null)
            return false;
        Entry tmp = head.next;
        while (tmp != null && tmp != head)
            tmp = tmp.next;
        return (tmp != null);
    }

    //两个链表是否相交
//    public static boolean isIntersect(Entry a, Entry b) {
//
//    }

    public static void main(String[] args) {
        Random r = new Random();
        Entry pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        ListUtil.displayList(pre);
        System.out.println(isLoop(pre));
    }

}
