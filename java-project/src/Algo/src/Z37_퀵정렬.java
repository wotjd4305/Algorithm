package Algo.src;

import java.util.Arrays;

//반복문
public class Z37_퀵정렬 {

	public static void main(String args[]){
		int a[] = {4,6,8,3,7,1,2,5,9,0};
		quickSort(a,0, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}

	//a[] 정렬할 배열, begin : 첫 인덱스, end: 마지막 인덱스
	private static void quickSort(int[] a, int l, int r) {
		if(l<r) {
			int pivot = partition(a,l,r); //피봇을 기준으로 앞(작은수), 뒤 (큰수) 배
			quickSort(a,l,pivot-1);
			quickSort(a,pivot+1,r);
			
		}
		
	}

	private static int partition(int[] a, int l, int r) {
		int pivot = l;
		while(l <= r) {
			while(l < a.length && a[l] <= a[pivot]) l++;//ok
			while(0 <= r &&a[pivot] < a[r]) r--;
			if(l<r) {
				int temp = a[l];
				a[l] = a[r];
				a[r] = temp;
			}
		}	
		
		// 피봇의 위치를 작은 숫자 끝 수와 swap
		int temp = a[r];
		a[r] = a[pivot];
		a[pivot] = temp;
		return r;
	}
	
}
