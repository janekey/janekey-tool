package com.janekey.datastructure.map;

/**
 * User: qi.zheng
 * Date: 13-6-21
 * Time: 下午3:37
 */
public class TreeMap<K, V> {

    private Entry<K, V> root = null;
    private int size;

    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        Entry<K, V> t = root;
        if (t == null) {
            root = new Entry<K, V>(key, value, null);
            size = 1;
            return null;
        }
        int cmp;
        Entry<K, V> parent;
        if (key == null)
            throw new NullPointerException();
        Comparable<? super K> k = (Comparable<? super K>) key;
        do {
            parent = t;
            cmp = k.compareTo(t.key);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else
                return t.value = value;
        } while (t != null);
        Entry<K, V> e = new Entry<K, V>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);
        size++;
        return null;
    }

    public V get(Object key) {
        Entry<K, V> p = getEntry(key);
        return (p == null ? null : p.value);
    }

    @SuppressWarnings("unchecked")
    Entry<K, V> getEntry(Object key) {
        if (key == null)
            throw new NullPointerException();
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K, V> p = root;
        while (p != null) {
            int cmp = k.compareTo(p.key);
            if (cmp < 0)
                p = p.left;
            else if (cmp > 0)
                p = p.right;
            else
                return p;
        }
        return null;
    }

    /** From CLR */
    private void fixAfterInsertion(Entry<K,V> x) {
        x.color = RED;
        // x不为空，不为根节点，并且父节点为红色
        while (x != null && x != root && x.parent.color == RED) {
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) { //父节点为祖父节点的左子节点
                Entry<K,V> y = rightOf(parentOf(parentOf(x)));  //祖父节点的右子节点(叔父节点)
                if (colorOf(y) == RED) {    //叔父节点为红色
                    setColor(parentOf(x), BLACK);   //父节点、叔父节点重绘为黑色，祖父节点重绘为红色
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));  //从祖父节点再次开始递归
                } else {    //叔父节点为黑色
                    if (x == rightOf(parentOf(x))) {    //新节点为父节点的右子节点
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            } else {    //父节点为祖父节点的右子节点
                Entry<K,V> y = leftOf(parentOf(parentOf(x)));   //祖父节点的左子节点(叔父节点)
                if (colorOf(y) == RED) {
                    setColor(parentOf(x), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                } else {
                    if (x == leftOf(parentOf(x))) {
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x), BLACK);
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        root.color = BLACK;
    }

    private static <K, V> Entry<K, V> parentOf(Entry<K, V> p) {
        return (p == null ? null : p.parent);
    }

    private static <K, V> void setColor(Entry<K, V> p, boolean color) {
        if (p != null)
            p.color = color;
    }

    private static <K, V> boolean colorOf(Entry<K, V> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <K, V> Entry<K, V> leftOf(Entry<K, V> p) {
        return (p == null ? null : p.left);
    }

    private static <K, V> Entry<K, V> rightOf(Entry<K, V> p) {
        return (p == null ? null : p.right);
    }

    /*********** 左旋转/右旋转 ************
        +---+                           +---+
        | P |                           | r |
        +---+                           +---+
             \     left rotation       /
            +---+  ------------->  +---+
            | r |  <-------------  | P |
            +---+  right rotation  +---+
            /                           \
        +---+                             +---+
        | C |                             | C |
        +---+                             +---+
    ********************************/
    private void rotateLeft(Entry<K,V> p) {
        if (p != null) {
            Entry<K,V> r = p.right;
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    private void rotateRight(Entry<K,V> p) {
        if (p != null) {
            Entry<K,V> l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    static final class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> left = null;
        Entry<K, V> right = null;
        Entry<K, V> parent;
        boolean color = BLACK;
        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Entry))
                return false;
            Entry e = (Entry) o;
            return (key == null ? e.key == null : key.equals(e.key))
                    && (value == null ? e.value == null : value.equals(e.value));
        }

        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        public String toString() {
            return key + "=" + value;
        }
    }

}
