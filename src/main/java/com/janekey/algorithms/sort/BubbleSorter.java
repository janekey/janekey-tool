package com.janekey.algorithms.sort;

/**
 * 冒泡排序，算法思想简单，效率低
 * 冒泡排序与插入排序拥有相等的执行时间，但两种方法需要交换的次数却很大的不同。最坏的情况冒泡需要O(n2)次交换，而插入只需要O(n)次交换。
 * 因此很多地方避免使用冒泡而使用插入替代。
 * @author Jackey
 * @param <E>
 */
public class BubbleSorter<E extends Comparable<E>> extends BaseSorter<E> {

	@Override
	public void sort(E[] array) {
        for (int i = array.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j + 1);
            }

	}
}
