package com.janekey.algorithms.sort;

/**
 * 归并排序，将两个已经排好序的序列合并成一个序列的操作。
 * 最差时间复杂度O(nlogn) 最优时间复杂度O(n) 平均时间复杂度O(nlogn)
 * 最差空间复杂度O(n)
 * User: qi.zheng
 * Date: 13-5-14
 * Time: 下午5:59
 */
public class MergeSorter<E extends Comparable<E>> extends BaseSorter<E> {
    @Override
    @SuppressWarnings("unchecked")
    public void sort(E[] array) {
        Object[] tmp = new Comparable[array.length];
        mergeSort(array, 0, array.length - 1, (E[]) tmp);
    }

    private void mergeSort(E[] array, int left, int right, E[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, tmp);
            mergeSort(array, mid + 1, right, tmp);
            merge(array, tmp, left, mid + 1, right);
        }
    }

    private void merge(E[] array, E[] tmp, int lPos, int rPos, int rEnd) {
        int lEnd = rPos - 1;
        int tPos = lPos;    //tmp position
        int lPosInit = lPos;

        while (lPos <= lEnd && rPos <= rEnd) {
            if (array[lPos].compareTo(array[rPos]) <= 0)
                tmp[tPos++] = array[lPos++];
            else
                tmp[tPos++] = array[rPos++];
        }

        while (lPos <= lEnd)
            tmp[tPos++] = array[lPos++];
        while (rPos <= rEnd)
            tmp[tPos++] = array[rPos++];

        // 将排好序的临时数组中放回源数组
        for (; rEnd >= lPosInit; rEnd--)
            array[rEnd] = tmp[rEnd];
    }
}
