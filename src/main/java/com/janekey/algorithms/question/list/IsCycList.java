package com.janekey.algorithms.question.list;

import java.util.Random;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 上午11:55
 */
public class IsCycList {

    /**
     * 【判断链表是否有环】
     * 使用两个引用变量n1，n2。分别走一步和走两步。
     * 如果存在环必定会相遇，如果不存在，则n2会到链表尾部(null)
     *
     * ·如果想计算环的长度，只需要找到刚才的碰撞点开始走，再走到自己时就是环的长度。
     * ·找出环的连接点：有定理：碰撞点到连接点的距离=头节点到连接点的距离。
     */
    public static boolean isCyc(Entry head, int n) {
        if (head == null)
            return false;
        Entry n1 = head, n2 = head;
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                if (n == 1) cycNode1 = n1;
                else cycNode2 = n1;
                return true;
            }
        }
        return false;
    }

    /**
     * 两个链表是否相交
     */
    static Entry cycNode1;//用于判断两个有环链表是否相交
    static Entry cycNode2;
    public static boolean isIntersect(Entry a, Entry b) {

        if (a == null || b == null)
            return false;

        boolean aCyc = isCyc(a, 1);
        boolean bCyc = isCyc(b, 2);
        //如果两个都没有环，判断最后一个节点是否相等
        if (!aCyc && !bCyc) {
            Entry aFoot = a, bFoot = b;
            while (aFoot.next != null)
                aFoot = aFoot.next;
            while (bFoot.next != null)
                bFoot = bFoot.next;
            return aFoot == bFoot;
        } else if (aCyc != bCyc) {
            //如果一个有环，一个无环
            return false;
        } else {
            //如果两个都有环，判断环里的节点是否能到达另一个链表的环里的节点
            if (cycNode1 == cycNode2)
                return true;
            Entry tmp = cycNode1.next;

            while (tmp != cycNode1) {
                if (tmp == cycNode2)
                    return true;
                tmp = tmp.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
//        Random r = new Random();
//        Entry pre = null;
//        for (int i = 0; i < 10; i++) {
//            pre = new Entry(r.nextInt(10), pre);
//        }
//        ListUtil.displayList(pre);
//        System.out.println(isCyc(pre, 1));

        Entry a3 = new Entry(0, null);
        Entry a2 = new Entry(1, a3);
        Entry a1 = new Entry(2, a2);
        a3.next = a1;
        Entry a = new Entry(3, a1);

        Entry b2 = new Entry(3, null);
        Entry b1 = new Entry(3, b2);
        b2.next = a2;
        Entry b = new Entry(3, b1);

        System.out.println(isIntersect(a, b));
    }

}
