package com.janekey.algorithms.test;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-6-26
 * Time: 下午6:51
 */
public class ListTester {

    //反转链表（循环）
    public static Entry reverseCyc(Entry head) {
        if (head == null || head.next == null)
            return head;

        Entry next = head.next;
        Entry pre = head;
        Entry tmp;
        while (next != null) {
            tmp = next;
            next = next.next;
            tmp.next = pre;
            pre = tmp;
        }
        head.next = null;
        return pre;
    }

    //反转链表（递归）
    static Entry newHead;
    public static Entry reverseRecursive(Entry head) {
        if (head == null || head.next == null) {
            newHead = head;
            return head;
        } else {
            Entry tmp = reverseRecursive(head.next);
            tmp.next = head;
            head.next = null;
            return head;
        }
    }

    public static Entry mergeSorted(Entry a, Entry b) {
        if (a == null) return b;
        if (b == null) return a;
        Entry newHead = new Entry(0, a);
        Entry tmp = newHead;
        while (a != null && b != null) {
            if (a.value < b.value) {
                tmp.next = a;
                a = a.next;
            } else {
                tmp.next = b;
                b = b.next;
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
        return newHead.next;
    }

    static class Entry {
        int value;
        Entry next;

        Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    static Random r = new Random();
    public static void main(String[] args) {
//        testReverse();
        testMerge();
    }

    public static void testReverse() {
        Entry pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        displayList(pre);
        // 循环方法
        Entry newHead1 = reverseCyc(pre);
        displayList(newHead1);
        // 递归方法
        reverseRecursive(newHead1);
        if (newHead != null) {
            Entry tmp = newHead;
            while (tmp != null) {
                System.out.print(tmp.value + "\t");
                tmp = tmp.next;
            }
        }
    }

    public static void testMerge() {
        Entry a = null, b = null;
        for (int i = 0; i < 10; i++) {
            a = new Entry(10 * (9 - i) + r.nextInt(10), a);
            b = new Entry(10 * (9 - i) + r.nextInt(10), b);
        }
        displayList(a);
        displayList(b);
        Entry c = mergeSorted(a, b);
        displayList(c);
    }

    static void displayList(Entry head) {
        if (head != null) {
            Entry tmp = head;
            while (tmp != null) {
                System.out.print(tmp.value + "\t");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

}
