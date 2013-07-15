package com.janekey.algorithms.question.list;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午12:00
 */
public class ListUtil {

    public static void displayList(Entry head) {
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
