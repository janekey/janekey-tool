package com.janekey.algorithms.sort;

/**
 * 堆排序
 *
 * User: Janekey(janekey.com)
 * Date: 13-5-21
 * Time: 上午12:20
 */
public class HeapSorter<E extends Comparable<E>> extends BaseSorter<E> {

    @Override
    public void sort(E[] array) {
        buildMaxHeapify(array);
        heapSort(array);
    }

    private void buildMaxHeapify(E[] data) {
        int startIndex = getParentIndex(data.length - 1);

        for (int i = startIndex; i >= 0; i--)
            maxHeapify(data, data.length, i);
    }

    /**
     * 创建最大堆
     * @param data        原数组
     * @param heapSize    需要创建的最大堆的大小
     * @param index       当前需要创建最大堆的位置
     */
    private void maxHeapify(E[] data, int heapSize, int index) {
        // 当前点于左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[left].compareTo(data[index]) > 0)
            largest = left;
        else if (right < heapSize && data[right].compareTo(data[largest]) > 0)
            largest = right;

        // 发现原来的data[0]不是最大值
        if (largest != index) {
            E temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }


    }

    /**
     * 排序，最大值放在末尾，数组data虽然原来是最大堆，排序之后就变成递增的了
     */
    private void heapSort(E[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            E temp = data[0]; //最大值
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    /**
     * 父节点位置
     */
    private int getParentIndex(int current) {
        return (current - 1) >> 1;
    }

    /**
     * 左子节点位置
     */
    private int getChildLeftIndex(int current) {
        return (current << 1) + 1;
    }

    /**
     * 右子节点位置
     */
    private int getChildRightIndex(int current) {
        return (current << 1) + 2;
    }

}
