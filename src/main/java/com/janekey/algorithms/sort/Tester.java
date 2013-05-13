package com.janekey.algorithms.sort;

import java.util.Calendar;

public class Tester {
	
	public static void main(String[] args) {
		
		test(new InsertSorter<Integer>());// 插入排序
		test(new BubbleSorter<Integer>());// 冒泡排序
		test(new SelectSorter<Integer>());// 选择排序
		test(new QuickSorter<Integer>());// 快速排序
		
//		displayArray(list);
		
	}
	
	public static void test(Sorter<Integer> sorter) {
		int size = 3000;
		Integer[] list = new Integer[size];
		for(int i = 0; i < size; i++) {
			list[i] = (int) Math.random() * size;
		}
		
//		System.out.println("size : " + list.length);
		long startTime = Calendar.getInstance().getTimeInMillis();
		
		sorter.sort(list);
		
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("time: " + (endTime - startTime) + "ms");
	}
	
	public static void displayArray(Comparable<?>[] array) {
		for(Comparable<?> a : array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
