package com.janekey.algorithms.question.tree;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午12:24
 */
public class BalanceTree {

    //返回树的高度
    int depthTree(TreeNode t) {
        if (t == null)
            return 0;
        int leftDepth = depthTree(t.left);
        int rightDepth = depthTree(t.right);
        return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
    }

    //判断是否是平衡二叉树
    boolean isBalance(TreeNode t) {
        if (t == null)
            return true;
        int leftDepth = depthTree(t.left);
        int rightDepth = depthTree(t.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
            return false;
        else
            return isBalance(t.left) && isBalance(t.right);
    }

}
