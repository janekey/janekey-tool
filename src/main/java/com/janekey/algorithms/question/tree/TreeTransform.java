package com.janekey.algorithms.question.tree;

import java.util.Random;
import java.util.Stack;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午12:56
 */
public class TreeTransform {

    public static void main(String[] args) {

        Random r = new Random();
        TreeNode root = new TreeNode(10);
        for (int i = 0; i < 10; i++) {
            put(root, new TreeNode(r.nextInt(20)));
        }
        TraversalTree.inorder(root);
        System.out.println();

//        mirror(root);
//        mirrorCyc(root);
//        TraversalTree.inorder(root);

        TreeNode head = root;
        while (head.left != null)
            head = head.left;
        treeToList(root);

        TreeNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.right;
        }
    }

    //二叉树转镜像（左右子树对调）(递归)
    static void mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    }

    //(循环)  (非递归的先序遍历也是这种方式：使用Stack，先放right)
    static void mirrorCyc(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);
        while (!stack.empty()) {
            TreeNode n = stack.pop();
            TreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;
            if (n.left != null) stack.push(n.left);
            if (n.right != null) stack.push(n.right);
        }
    }

    //二叉树转链表
    static void treeToList(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            TreeNode pre = getMax(root.left);
            treeToList(root.left);
            pre.right = root;
            root.left = pre;
        }
        if (root.right != null) {
            TreeNode next = getMin(root.right);
            treeToList(root.right);
            next.left = root;
            root.right = next;
        }
    }

    static TreeNode getMax(TreeNode node) {
        if (node == null || node.right == null)
            return node;
        return getMax(node.right);
    }
    static TreeNode getMin(TreeNode node) {
        if (node == null || node.left == null)
            return node;
        return getMin(node.left);
    }

    static void put(TreeNode root, TreeNode node) {
        if (root == null || node == null)
            return;

        if (node.value <= root.value) {
            if (root.left == null) {
                root.left = node;
            } else {
                put(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                put(root.right, node);
            }
        }
    }

}
