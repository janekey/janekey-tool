package com.janekey.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 红黑树
 * User: qi.zheng
 * Date: 13-5-23
 * Time: 下午2:14
 */
public class RBTree {

    TreeNode root;
    private static final boolean RED   = false;
    private static final boolean BLACK = true;

    // 建立红黑树
    public void create(int[] list) {
        for (int i : list)
            this.insert(i);
    }

    public void insert(int element) {
        TreeNode node = new TreeNode(element);

        // 判断根是否为空,如果为空,则将root指向新元素.否则,进入循环
        if (root == null) {
            root = node;
            root.color = RED;
            return;
        } else {
            // 定义四个指针,分别指向祖先,祖,父,自身
            TreeNode p = root, q;
            TreeNode parent = root;
            TreeNode grand = root;
            TreeNode ancestor = root;
            while (p != null) {
                // 如果P的左右孩子均不为空且颜色均为红色,则执行颜色转换并进行调整
                if (p.left != null && p.right != null) {
                    if (p.left.color == BLACK && p.right.color == BLACK) {
                        // 注释说是红色，代码中是黑色？？？？
                        convertColor(p);
                        adjust(ancestor, grand, parent, p);
                    }
                }

                if (element == p.data)
                    return;

                q = p;  // 指针依次向后移动
                ancestor = grand;
                grand = parent;
                parent = p;

                // 如果元素小于P
                if (element < q.data) {
                    // P的左孩子为空
                    if (q.left == null) {
                        // 将P的做孩子指向新建元素
                        q.left = node;
                        p = node;   // 调整
                        adjust(ancestor, grand, parent, p);
                        return;
                    } else {
                        // P向左下移动
                        p = p.left;
                    }
                } else {
                    if (element > q.data) {
                        if (q.right == null) {
                            // 将P的右孩子指向新建元素
                            q.right = node;
                            p = node;   // 调整
                            adjust(ancestor, grand, parent, p);
                            return;
                        } else {
                            // P向右下移动
                            p = p.right;
                        }
                    }
                }
            }
        }
    }

    // 是否存在黑黑冲突
    public void adjust(TreeNode ancestor, TreeNode grand, TreeNode parent, TreeNode x) {
        if (!(parent.color == BLACK && x.color == BLACK))
            return;
        // 符合一次调整的,将调用一次调整
        if ((grand.left == parent && parent.left == x)
                || (grand.right == parent && parent.right == x)) {
            onceAdjust(ancestor, grand, parent, x);
            return;
        }
        // 符合二次调整的,将调用二次调整
        if ((grand.left == parent && parent.right == x)
                || (grand.right == parent && parent.left == x)) {
            twiceAdjust(ancestor, grand, parent, x);
            return;
        }
    }

    // 调整父结点和祖结点的颜色
    private void onceAdjust(TreeNode ancestor, TreeNode grand, TreeNode parent, TreeNode x) {
        this.exchangeColor(grand);
        this.exchangeColor(parent);
        // 将祖先结点指向父结点
        if (ancestor == grand && ancestor == this.root) {
            this.root = parent;
            ancestor = parent;
        } else {
            if (ancestor.left == grand) {
                ancestor.left = parent;
            } else if (ancestor.right == grand) {
                ancestor.right = parent;
            }
        }

        // 左左型调整
        if (grand.left == parent && parent.left == x) {
            grand.left = parent.right;
            parent.right = grand;
            return;
        }

        // 右右型调整
        if (grand.right == parent && parent.right == x) {
            grand.right = parent.right;
            parent.left = grand;
            return;
        }
    }

    // 调整自身结点和祖结点的颜色
    private void twiceAdjust(TreeNode ancestor, TreeNode grand, TreeNode parent, TreeNode x) {
        this.exchangeColor(grand);
        this.exchangeColor(x);
        // 将祖先结点指向自身结点
        if (ancestor == grand && ancestor == root) {
            root = x;
            ancestor = x;
        } else {
            if (ancestor.left == grand) {
                ancestor.left = x;
            } else if (ancestor.right == grand) {
                ancestor.right = x;
            } else if (ancestor == root) {
                ancestor = x;
                root = x;
            }
        }

        // 左右型调整
        if (grand.left == parent && parent.right == x) {
            grand.left = x.right;
            parent.right = x.left;
            x.left = parent;
            x.right = grand;
            return;
        }

        // 右左型调整
        if (grand.right == parent && parent.left == x) {
            grand.right = x.left;
            parent.left = x.right;
            x.left = grand;
            x.right = parent;
            return;
        }
    }

    // 变换颜色的方法
    private void exchangeColor(TreeNode p) {
        if (p.color == BLACK) {
            p.color = RED;
        } else {
            p.color = BLACK;
        }
    }

    // 调整颜色
    public void convertColor(TreeNode p) {
        // 将P的左右孩子的颜色均置为红
        p.left.color = RED;
        p.right.color = RED;
        // 若P为根结点,则颜色仍为红,否则颜色置为黑
        if (!p.equals(root)) {
            p.color = BLACK;
            return;
        }
        if (p.equals(root))
            p.color = RED;
    }

    public void inorder() {
        System.out.println("root:" + root.data);
        inorder(root);
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

        TreeNode(int data) {
            this.data = data;
        }
    }

}
