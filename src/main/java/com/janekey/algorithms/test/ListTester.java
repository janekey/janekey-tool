package com.janekey.algorithms.test;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-6-26
 * Time: 下午6:51
 */
public class ListTester {

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

    static class Entry {
        int value;
        Entry next;

        Entry(int value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        Entry pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        displayList(pre);
        // 循环方法
        Entry newHead1 = reverseCyc(pre);
        displayList(newHead1);

        pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        displayList(pre);
        // 递归方法
        reverseRecursive(pre);
        if (newHead != null) {
            Entry tmp = newHead;
            while (tmp != null) {
                System.out.print(tmp.value + "\t");
                tmp = tmp.next;
            }
        }
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
