package com.janekey.algorithms.question.list;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午12:02
 */
public class MergeList {

    //将两个有序链表合并成一个有序链表
    public static Entry mergeSorted(Entry a, Entry b) {
        if (a == null) return b;
        if (b == null) return a;

        Entry newList = new Entry(0, a);
        Entry tmp = newList;
        while (a != null && b != null) {
            if (a.value >= b.value) {
                tmp.next = b;
                b = b.next;
            } else {
                tmp.next = a;
                a = a.next;
            }
            tmp = tmp.next;
        }
        while (a != null) {
            tmp.next = a;
            tmp = tmp.next;
            a = a.next;
        }
        while (b != null) {
            tmp.next = b;
            tmp = tmp.next;
            b = b.next;
        }
        return newList.next;
    }

    public static void main(String[] args) {
        Random r = new Random();
        Entry a = null;
        for (int i = 0; i < 10; i++) {
            a = new Entry(10 * (9 - i) + r.nextInt(10), a);
        }
        ListUtil.displayList(a);
        Entry b = null;
        for (int i = 0; i < 10; i++) {
            b = new Entry(10 * (9 - i) + r.nextInt(10), b);
        }
        ListUtil.displayList(b);

        Entry newList = mergeSorted(a, b);
        ListUtil.displayList(newList);
    }
}
