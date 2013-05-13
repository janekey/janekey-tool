package com.janekey.algorithms.sort;

/**
 * 冒泡排序，算法思想简单，效率低
 * 
 * @author Jackey
 * @param <E>
 */
public class BubbleSorter<E extends Comparable<E>> extends Sorter<E> {

	@Override
	public void sort(E[] array) {
		// 升序

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					swap(array, i, j);
				}
			}
		}

	}
}
