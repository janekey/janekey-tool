package com.janekey.datastructure.tree;

/**
 * 红黑树
 * 红黑树是一种自平衡二叉查找树。
 * 它是高效的：可以再O(log n)时间内做查找，插入和删除，其中n是树中元素的数目。
 * 红黑树的性质：
 * 性质1. 节点是红色或黑色。
 * 性质2. 根是黑色。
 * 性质3. 所有叶子都是黑色（叶子是NIL节点）。
 * 性质4. 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
 * 性质5. 从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点。
 * 以上这些约束产生了关键性质：从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。
 *
 * User: qi.zheng
 * Date: 13-5-23
 * Time: 下午2:14
 */
public class RBTree {

    private TreeNode root;
    private int size;

    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    public void insert(int data) {
        TreeNode t = root;
        if (t == null) {
            root = new TreeNode(data, null);
            size = 1;
            return;
        }
        TreeNode newNode = insert(data, root);
        fixAfterInsertion(newNode);
        size++;
    }

    private TreeNode insert(int data, TreeNode node) {
        if (data < node.data) {
            if (node.left != null)
                return insert(data, node.left);
            else
                return (node.left = new TreeNode(data, node));
        } else if (data > node.data) {
            if (node.right != null)
                return insert(data, node.right);
            else
                return (node.right = new TreeNode(data, node));
        } else {
            return null;
        }
    }

    private TreeNode parentOf(TreeNode n) {
        return n == null ? null : n.parent;
    }

    private TreeNode grandparentOf(TreeNode n) {
        return parentOf(parentOf(n));
    }

    private TreeNode uncleOf(TreeNode n) {
        if (grandparentOf(n) != null) {
            if (parentOf(n) == grandparentOf(n).left)
                return grandparentOf(n).right;
            else
                return grandparentOf(n).left;
        } else {
            return null;
        }

    }

    private void fixAfterInsertion(TreeNode n) {
        if (n != null ) {
            n.color = RED;
            insertCase1(n);
        }
    }

    /**
     * 新节点N位于根节点上，没有父节点。
     * 将N重绘为黑色。
     */
    private void insertCase1(TreeNode n) {
        if (n.parent == null)   //根节点
            root.color = BLACK;
        else
            insertCase2(n);
    }

    /**
     * 新节点的父节点是黑色。
     * 新节点是红色的，这时对新的树没有影响，5个性质都未受到威胁，任然成立。
     */
    private void insertCase2(TreeNode n) {
        //父节点是黑色的话5个性质任然有效
        if (n.parent.color == RED)
            insertCase3(n);
    }

    /**
     * 父节点P和叔父节点U都为红色。
     * 这时将P和U两个节点重绘为黑色，并且祖父节点G重绘为红色。
     * 这样性质1、3、5都能成立，不过这时有可能G为根节点，或者G的父节点为红色，不符合性质2或4。
     * 这时将G视为新插入的节点，对其从情况1开始递归。
     */
    private void insertCase3(TreeNode n) {
        if (uncleOf(n) != null && uncleOf(n).color == RED) {
            n.parent.color = BLACK;
            uncleOf(n).color = BLACK;
            grandparentOf(n).color = RED;
            insertCase1(grandparentOf(n));
        } else {
            insertCase4(n);
        }
    }

    /**
     * 父节点P是红色而叔父节点U是黑色或缺少，并且N节点是P节点的右子节点而P又是G的左节点。
     * 这种情况下对父节点P进行左旋转，然后以情况5处理节点P来解决失效的性质4。
     */
    private void insertCase4(TreeNode n) {
        if (n == n.parent.right && n.parent == grandparentOf(n).left) {
            rotateLeft(n.parent);
            n = n.left;
        } else if (n == n.parent.left && n.parent == grandparentOf(n).right) {
            rotateRight(n.parent);
            n = n.right;
        }
        insertCase5(n);
    }

    /**
     * 父节点P是红色而叔父节点U是黑色或缺少，新节点N是其父节点P的左子节点，父节点P又是祖父节点G的左子节点。
     * 这种情况下对祖父节点G进行右旋转，同时将G重绘为红色，P重绘为黑色。
     */
    private void insertCase5(TreeNode n) {
        n.parent.color = BLACK;
        grandparentOf(n).color = RED;
        if (n == n.parent.left && n.parent == grandparentOf(n).left) {
            rotateRight(grandparentOf(n));
        } else {
            rotateLeft(grandparentOf(n));
        }
    }

    /*********** 左旋转/右旋转 ************
     +---+                           +---+
     | n |                           | r |
     +---+                           +---+
         \     left rotation       /
         +---+  ------------->  +---+
         | r |  <-------------  | n |
         +---+  right rotation  +---+
         /                           \
     +---+                             +---+
     | C |                             | C |
     +---+                             +---+
     ********************************/
    private void rotateLeft(TreeNode n) {
        if (n != null) {
            TreeNode r = n.right;
            n.right = r.left;
            if (r.left != null)
                r.left.parent = n;
            r.parent = n.parent;
            if (n.parent == null)
                root = r;
            else if (n.parent.left == n)
                n.parent.left = r;
            else
                n.parent.right = r;
            r.left = n;
            n.parent = r;
        }
    }

    private void rotateRight(TreeNode n) {
        if (n != null) {
            TreeNode l = n.left;
            n.left = l.right;
            if (l.right != null) l.right.parent = n;
            l.parent = n.parent;
            if (n.parent == null)
                root = l;
            else if (n.parent.right == n)
                n.parent.right = l;
            else n.parent.left = l;
            l.right = n;
            n.parent = l;
        }
    }

    public int size() {
        return size;
    }

    // 中序遍历
    private void inorder(TreeNode root) {

        if (root != null) {
            System.out.println(root.data);

            inorder(root.left);
//            System.out.print(root.data + " " + root.color);
//            System.out.print(" (left : "
//                    + ((root.left != null) ? root.left.data : "null")
//                    + ", right : " + ((root.right != null) ? root.right.data : "null")
//                    + ") ");
//            System.out.println();
            inorder(root.right);
        }
    }

    static final class TreeNode {
        int data;
        boolean color = BLACK;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent;

        TreeNode(int data, TreeNode parent) {
            this.data = data;
            this.parent = parent;
        }
    }

}
