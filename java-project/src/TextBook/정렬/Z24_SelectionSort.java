package TextBook.정렬;

import java.util.Arrays;

public class Z24_SelectionSort {
	public static void main(String args[]) {

		int a[] = { 5, 7, 2, 9, 3, 6, 1, 4, 8 };// 9개
		// 0~8의 최소값 a[0] <-> a[k]
		// 1~8의 최소값 a[1] <-> a[k]
		// ...
		// i~8의 최소값 a[8] <-> a[k]
		for (int i = 0; i < a.length; i++) {// 영역의 시작위치를 지정할변수
			int min = Integer.MAX_VALUE;
			int minIndex = i;
			for (int j = i; j < a.length; j++) {
				if(min > a[j]){
					min = a[j];
					minIndex = j;
				}		
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		System.out.println(Arrays.toString(a));

	}// main
}// class