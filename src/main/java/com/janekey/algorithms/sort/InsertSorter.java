package com.janekey.algorithms.sort;

/**
 * 插入排序，对于较小的数组时候，该方法十分高效
 * @author Jackey
 * @param <E>
 */
public class InsertSorter<E extends Comparable<E>> extends Sorter<E> {

	@Override
	public void sort(E[] array) {
		// 升序
		
		// 临时值，存储当前循环到的值
		E temp = null;

		for (int i = 1; i < array.length; i++) {
			temp = array[i];

			int j = i;
			// 循环之前已经排列好的从小到大的序列
			for (; j > 0; j--) {
				if (array[j-1].compareTo(temp) > 0)
					array[j] = array[j-1];
				else
					break;
			}

			array[j] = temp;
		}

	}

}
