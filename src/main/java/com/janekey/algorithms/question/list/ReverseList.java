package com.janekey.algorithms.question.list;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 上午11:17
 */
public class ReverseList {

    //反转链表（循环，非递归）
    public static Entry reverseCyc(Entry head) {
        if (head == null || head.next == null)
            return head;

        Entry tmp;
        Entry next = head.next;
        Entry pre = head;

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
    static Entry recursiveNewHead;
    public static Entry reverseRecursive(Entry head) {
        if (head == null || head.next == null) {
            recursiveNewHead = head;
            return head;
        } else {
            Entry tmp = reverseRecursive(head.next);
            tmp.next = head;
            head.next = null;
            return head;
        }

    }

    public static void main(String[] args) {
        Random r = new Random();
        Entry pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        displayList(pre);
        Entry newHead = reverseCyc(pre);
        displayList(newHead);

        pre = null;
        for (int i = 0; i < 10; i++) {
            pre = new Entry(r.nextInt(10), pre);
        }
        displayList(pre);
        reverseRecursive(pre);
        displayList(recursiveNewHead);
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
