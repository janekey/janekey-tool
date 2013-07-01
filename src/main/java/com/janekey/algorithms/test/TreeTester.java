package com.janekey.algorithms.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: qi.zheng
 * Date: 13-7-1
 * Time: 下午5:41
 */
public class TreeTester {

    static void levelorder(Tree t) {
        if (t == null)
            return;
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.offer(t);
        while (queue.size() > 0) {
            Tree tmp = queue.poll();
            System.out.println(tmp.value);
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
    }

    static void preorder(Tree t) {
        if (t == null) return;
        System.out.println(t.value);
        preorder(t.left);
        preorder(t.right);
    }

    static void inorder(Tree t) {
        if (t == null) return;
        inorder(t.left);
        System.out.println(t.value);
        inorder(t.right);
    }

    static void postorder(Tree t) {
        if (t == null) return;
        postorder(t.left);
        postorder(t.right);
        System.out.println(t.value);
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        Tree(int value) {
            this.value = value;
        }
    }
}
