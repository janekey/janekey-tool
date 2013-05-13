package com.janekey.algorithms.test;

public class A {
	
	public static void main(String[] args) {
		
		int a[] = new int[]{1, 3, 4, 5, 6, 7, 8};
		int b[] = new int[]{2,5,9};
		int c[] = new int[]{1,3,6,8,9};
		
		int [] value = merge(a, b, c);
		
		for(int v : value)
			System.out.print(v);
	}
	
	public static int[] merge(int a[], int b[], int c[]) {
		int[] value = new int[a.length + b.length + c.length];
		
		int i = 0;
		int j = 0;
		int k = 0;
		int n = 0;
		while(i < a.length && j < b.length && k < c.length) {
			if(a[i] <= b[j] && a[i] <= c[k]) {
				value[n] = a[i];
				n++;i++;
			} else if(b[j] <= a[i] && b[j] <= c[k]) {
				value[n] = b[j];
				n++;j++;
			} else {
				value[n] = c[k];
				n++;k++;
			}
		}
		return value;
	}

}
