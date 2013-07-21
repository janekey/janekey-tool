package com.janekey.algorithms.sort;

/**
 * 希尔排序时插入排序的一种高速而稳定的改进版
 * User: qi.zheng
 * Date: 13-5-14
 * Time: 下午4:26
 */
public class ShellSorter<E extends Comparable<E>> extends BaseSorter<E> {

    @Override
    public void sort(E[] array) {
        int value = 1;
        while ((value + 1) * 2 < array.length)
            value = (value + 1) * 2 - 1;

        for (int n = value; n >= 1; n = (n + 1) / 2 - 1)
            shellSort(array, n);
    }

    private void shellSort(E[] array, int n) {
        for (int i = n; i < array.length; i+=n) {
            E tmp = array[i];
            int j = i;
            for (; j > 0 && array[j - n].compareTo(tmp) > 0; j -= n)
                array[j] = array[j - n];

            array[j] = tmp;
        }

    }

}
