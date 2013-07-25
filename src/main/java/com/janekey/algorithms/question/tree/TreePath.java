package com.janekey.algorithms.question.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午4:52
 */
public class TreePath {

    static Stack<Integer> stack = new Stack<Integer>();
    static int sum;
    //在树中找出 和为值expected的所有路径(也可以通过这个方法找出根到某节点的路劲)
    public static void treePath(TreeNode node, int expected) {
        if (node == null)
            return;

        stack.push(node.value);
        sum += node.value;
        if (sum == expected) {
            System.out.println(Arrays.toString(stack.toArray()));
        }

        if (node.left != null) {
            treePath(node.left, expected);
        }
        if (node.right != null)
            treePath(node.right, expected);

        sum -= node.value;
        stack.pop();
    }

    /**
     * 二叉树中两个节点的最近公共父节点
     */
    public static TreeNode findNearestPNode(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null)
            return null;
        if (root == a || root == b)
            return root;

        TreeNode leftNode = findNearestPNode(root.left, a, b);
        TreeNode rightNode = findNearestPNode(root.right, a, b);
        if (leftNode != null && rightNode != null)
            return root;
        return leftNode != null ? leftNode : rightNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        int expected = 22;
        TreeTransform.put(root, new TreeNode(7));
        TreeTransform.put(root, new TreeNode(12));
        TreeTransform.put(root, new TreeNode(5));
        TreeTransform.put(root, new TreeNode(0));
        TreeTransform.put(root, new TreeNode(8));

        TraversalTree.inorder(root);
        System.out.println();

        System.out.println("expected: " + expected);
        treePath(root, expected);
    }



}
