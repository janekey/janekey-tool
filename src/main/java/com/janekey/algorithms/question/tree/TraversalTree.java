package com.janekey.algorithms.question.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午12:21
 */
public class TraversalTree {

    // 层次遍历
    static void levelorder(TreeNode t) {
        if (t == null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(t);
        while (queue.size() > 0) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.value);
            if (tmp.left != null)
                queue.offer(tmp.left);
            if (tmp.right != null)
                queue.offer(tmp.right);
        }
    }

    //先序遍历
    static void preorder(TreeNode t) {
        if (t == null) return;
        System.out.println(t.value);
        preorder(t.left);
        preorder(t.right);
    }

    //中序遍历
    static void inorder(TreeNode t) {
        if (t == null) return;
        inorder(t.left);
        System.out.print(t.value + " ");
        inorder(t.right);
    }

    //后序遍历
    static void postorder(TreeNode t) {
        if (t == null) return;
        postorder(t.left);
        postorder(t.right);
        System.out.println(t.value);
    }
}
