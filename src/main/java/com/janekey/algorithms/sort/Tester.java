package com.janekey.algorithms.sort;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Tester {
	
	public static void main(String[] args) {
		
		test(new InsertSorter<Integer>());// 插入排序
		test(new BubbleSorter<Integer>());// 冒泡排序
		test(new SelectSorter<Integer>());// 选择排序
		test(new QuickSorter<Integer>());// 快速排序
		test(new ShellSorter<Integer>());// 希尔排序

//		displayArray(list);

	}
	
	public static void test(BaseSorter<Integer> sorter) {
		int size = 1000;
		Integer[] list = new Integer[size];
        Random random = new Random();
		for(int i = 0; i < size; i++) {
			list[i] = random.nextInt(500);
		}
		
//		System.out.println("size : " + list.length);
		long startTime = Calendar.getInstance().getTimeInMillis();

//        System.out.println(Arrays.toString(list));
		sorter.sort(list);
//        System.out.println(Arrays.toString(list));

		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("time: " + (endTime - startTime) + "ms");
	}

}
