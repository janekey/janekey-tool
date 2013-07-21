package com.janekey.algorithms.sort;

/**
 * 插入排序，对于较小的数组时候，该方法十分高效
 * 最差时间复杂度O(n2) 最优时间复杂度O(n) 平均时间复杂度O(n2)    (2次方)
 * 最差空间复杂度O(n) 需要辅助空间O(1)
 * @author Jackey
 * @param <E>
 */
public class InsertSorter<E extends Comparable<E>> extends BaseSorter<E> {

	@Override
	public void sort(E[] array) {
//        //下面这个代码方便不过交换次数增多
//        for (int i = 1; i < array.length; i++)
//            for (int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; j--)
//                    swap(array, j - 1, j);

        for (int i = 1; i < array.length; i++) {
            E temp = array[i];
            int j = i;
            for (; j > 0 && array[j - 1].compareTo(temp) > 0; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }


	}

}
