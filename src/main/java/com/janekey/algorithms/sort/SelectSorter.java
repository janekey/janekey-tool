package com.janekey.algorithms.sort;

/**
 * 选择排序
 * @author Jackey
 * @param <E>
 */
public class SelectSorter<E extends Comparable<E>> extends Sorter<E> {

	@Override
	public void sort(E[] array) {
		// 升序
		for (int i = 0; i < array.length; i++) {
			
			int smallestIndex = i;
			for (int j = i+1; j<array.length; j++) {
				if(array[j].compareTo(array[smallestIndex]) < 0) {
					smallestIndex = j;
				}
			}
			
			// 查找最小的
			if(smallestIndex != i)
				swap(array, smallestIndex, i);
		}
		
	}

}
