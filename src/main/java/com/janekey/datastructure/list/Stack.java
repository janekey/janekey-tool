package com.janekey.datastructure.list;

/**
 * User: qi.zheng
 * Date: 13-7-15
 * Time: 下午3:39
 */
public class Stack<E> {

    private Object[] data;
    private int size;

    public Stack() {
        data = new Object[10];
    }

    //查看栈顶对象，但不移除
    @SuppressWarnings("unchecked")
    public E peek() {
        return (E) data[size - 1];
    }

    //移除栈顶对象，并返回
    @SuppressWarnings("unchecked")
    public E pop() {
        Object o = data[size - 1];
        data[size--] = null;
        return (E) o;
    }

    //压入栈顶
    public E push(E item) {
        ensureCapacity(size + 1);
        data[size++] = item;
        return item;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
}
