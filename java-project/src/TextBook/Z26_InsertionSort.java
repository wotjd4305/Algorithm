package TextBook;

import java.util.ArrayList;
import java.util.Random;

public class Z26_InsertionSort{
	public static void main(String args[]) {
		long time = System.currentTimeMillis();
		Random ran = new Random();

//		int arr[] = { 5, 7, 2, 9, 3, 6, 1, 4, 8 };// 9개

		int[] arr = new int[3000];
		for(int i =0; i<3000; i++) {
			arr[i] = ran.nextInt(arr.length); 
		}
		
//		LinkedList<Integer> ll = new LinkedList<Integer>();
		ArrayList<Integer> ll = new ArrayList<>();
		
		for(int i = 0; i< arr.length; i++) {
			int index = 0;
			for(; index<i; index++) {
				if(arr[i] < ll.get(index)) {
					break;
				}
			}
			ll.add(index,arr[i]);//삽입
		}

		
		
		System.out.println(ll);
		System.out.println(System.currentTimeMillis() - time);
	}// main
}// class