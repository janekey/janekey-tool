package com.janekey.algorithms.search;

public class Search {
	
	/**
	 * 顺序查找算法.
	 * 优点是算法简单，且对表的结构没有任何要求.
	 * 缺点是查找效率低，因此，当表中元素个数比较多时，不宜采用顺序查找.
	 * @param r 查找表.
	 * @param k	关键字.
	 * @return 查找表中匹配的关键字的索引，若未查找到，则返回-1.
	 */
	public int sequenceSearch(int r[], int k) {
		for(int i=0; i<r.length; i++) {
			if(r[i] == k) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 折半查找(二分查找)算法.
	 * 默认r中的值已是从小到大的顺序.
	 * 优点是查找速度比顺序查找要快很多。
	 * 折半查找要求查找表按关键字有序，而排序是一种很费时的运算；
	 * 另外，折半查找要求表是顺序存储的，为保持表的有序性，在进行插入和删除操作时，都必须移动大量记录。
	 * 因此，折半查找的高查找效率是以牺牲排序为代价的，它特别适合于一经建立就很少移动、而又经常需要查找的线性表。
	 * @param r 查找表.
	 * @param k 关键字.
	 * @return 查找表中匹配的关键字的索引，若未查找到，则返回-1.
	 */
	public int binarySearch(int r[], int k) {
		int low = 0, high = r.length, mid = 0;
		while(low <= high) {
			mid = (low + high) / 2;
			if(k == r[mid]) {
				return mid;
			} else if(k < r[mid]){
				high = mid -1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

}
