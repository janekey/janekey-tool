package com.janekey.algorithms.sort;

/**
 * 快速排序是不稳定的，最差的时候时间度最长，递归的层数就是最大！有可能会引起栈溢出！
 * 归并排序是稳定的排序，最差和最好情况时间度是一样的！
 * 对于快速排序，关键值一般是取第一个，可以试着取中间位置的值,情况会有改善，但还是存在不稳定性！
 * @author Jackey
 * @param <E>
 */
public class QuickSorter<E extends Comparable<E>> extends Sorter<E> {

	@Override
	public void sort(E[] array) {

		quickSort(array, 0, array.length - 1);

	}

	private void quickSort(E[] array, int low, int high) {

		if (high - low < 1)
			return;
		int i = low;
		int j = high;

		int pivot = (low + high) / 2;

		E temp = array[pivot];
		array[pivot] = array[j];// 最右元素空出

		while (i != j) {

			// 找到左边数起第一个大于枢纽元素的元素
			while (i < j && array[i].compareTo(temp) <= 0) {
				i++;
			}
			if (i < j) {
				array[j] = array[i];
				j--;
			}

			// 找到右边数第一个小于枢纽元素的元素
			while (i < j && array[j].compareTo(temp) > 0) {
				j--;
			}
			if (i < j) {
				array[i] = array[j];
				i++;
			}

		}
		// 枢纽元素移到正确位置
		array[i] = temp;

		pivot = i;

		quickSort(array, low, pivot - 1);
		quickSort(array, pivot + 1, high);

	}
}
