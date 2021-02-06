package TextBook.이진;

import java.util.Scanner;

public class 이진탐색 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] Arr = { 10, 20, 30, 35, 40 };

		System.out.println(BinarySearch(Arr, 10));
	}

	public static int BinarySearch(int arr[], int findNum) {
		int start = 0;
		int end = arr.length - 1;
		int mid;
		int result = -1;

		while (start <= end) {
			mid = (start + end) / 2;

			if (arr[mid] == findNum) {
				result = mid;
				break;
			}
			if (arr[mid] > findNum) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
}