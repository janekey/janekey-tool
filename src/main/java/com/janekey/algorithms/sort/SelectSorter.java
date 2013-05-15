package com.janekey.algorithms.sort;

/**
 * 选择排序，对于n个元素的表进行排序总共最多进行n-1次交换。
 * 最差时间复杂度O(n2) 最优时间复杂度O(n2) 平均时间复杂度O(n2)
 * 最差空间复杂度O(n) 辅助空间O(1)
 * @author Jackey
 * @param <E>
 */
public class SelectSorter<E extends Comparable<E>> extends BaseSorter<E> {

	@Override
	public void sort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			
			int min = i;
			for (int j = i+1; j<array.length; j++) {
				if(array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			
			// 查找最小的
			if(min != i)
				swap(array, min, i);
		}
		
	}

}
