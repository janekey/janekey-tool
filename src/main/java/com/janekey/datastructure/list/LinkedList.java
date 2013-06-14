package com.janekey.datastructure.list;

import java.util.NoSuchElementException;

/**
 * User: qi.zheng
 * Date: 13-6-14
 * Time: 下午5:00
 */
public class LinkedList<E> {

    // header是引导作用 header的next存储第一个元素对象，header的previous存储最后一个元素对象
    private Entry<E> header = new Entry<E>(null, null, null);
    private int size;

    public LinkedList() {
        header.next = header.previous = header;
    }
    public void add(int index, E element) {
        addBefore(element, (index == size) ? header : entry(index));
    }

    public E remove(int index) {
        return remove(entry(index));
    }

    public E get(int index) {
        return entry(index).element;
    }

    public E set(int index, E element) {
        Entry<E> e = entry(index);
        E oldValue = e.element;
        e.element = element;
        return oldValue;
    }

    private static class Entry<E> {
        E element;
        Entry<E> next;
        Entry<E> previous;

        public Entry(E element, Entry<E> next, Entry<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

    // 获取在所索引位置的元素对象
    private Entry<E> entry(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        Entry<E> e = header;
        if (index < (size >> 1)) {  //所在索引在前半部分
            for (int i = 0; i <= index; i++)
                e = e.next;
        } else {
            for (int i = size; i > index; i--)
                e = e.previous;
        }
        return e;
    }

    // 从链表中删除给定的元素对象，将前后链表对象关联
    private E remove(Entry<E> e) {
        if (e == header)
            throw new NoSuchElementException();

        E result = e.element;
        e.previous.next = e.next;
        e.next.previous = e.previous;
        e.next = e.previous = null;
        e.element = null;
        size--;
        return result;
    }

    // 将元素e链接到entry元素对象前面
    private Entry<E> addBefore(E e, Entry<E> entry) {
        Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
        newEntry.next.previous = newEntry;
        newEntry.previous.next = newEntry;
        size++;
        return newEntry;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Entry e = header.next;
        while (e != header) {
            sb.append(e.element).append(",");
            e = e.next;
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
