package com.janekey.algorithms.sort;

/**
 * Basal Class.
 * @author Jackey.
 * @param <E>
 */
public abstract class BaseSorter<E extends Comparable<E>> {
	
	public abstract void sort(E[] array);
	
	protected final void swap(E[] array, int from, int to) {
		E temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

}
