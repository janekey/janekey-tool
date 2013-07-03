package com.janekey.algorithms.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: qi.zheng
 * Date: 13-7-1
 * Time: 下午5:41
 */
public class TreeTester {

    // 层次遍历
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

    //先序遍历
    static void preorder(Tree t) {
        if (t == null) return;
        System.out.println(t.value);
        preorder(t.left);
        preorder(t.right);
    }

    //中序遍历
    static void inorder(Tree t) {
        if (t == null) return;
        inorder(t.left);
        System.out.println(t.value);
        inorder(t.right);
    }

    //后序遍历
    static void postorder(Tree t) {
        if (t == null) return;
        postorder(t.left);
        postorder(t.right);
        System.out.println(t.value);
    }

    int depthTree(Tree t) {
        if (t == null)
            return 0;
        int leftDepth = depthTree(t.left);
        int rightDepth = depthTree(t.right);
        return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
    }
    //判断是否是平衡二叉树
    boolean isBalance(Tree t) {
        if (t == null)
            return true;
        int leftDepth = depthTree(t.left);
        int rightDepth = depthTree(t.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
            return false;
        else
            return isBalance(t.left) ^ isBalance(t.right);
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
