package TextBook;

import java.util.Arrays;

public class Z25_BubbleSort{
	public static void main(String args[]) {

		int a[] = { 5, 7, 2, 9, 3, 6, 1, 4, 8 };// 9개
		//영역은 0~8이지만 시작값은 0~7번임
		//01 12 23 34 45 56 67 78...
		
		//오름차순
		for(int i =a.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {// 0~7, j두개씩 비교할 시작위치 a[j] a[j+1]
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
		}
		System.out.println(Arrays.toString(a));

	}// main
}// class