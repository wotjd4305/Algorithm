package Algo.src.WorkShop;

import java.util.Arrays;
import java.util.Scanner;


public class Main_정올_1169_주사위던지기1_박재성 {
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int N;
	static int M;

	public static void main(String args[]) {

		// 던질횟수, 출력형식, 배열
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1];

		solution(N, M, arr);

	}// end of main

	public static void pprint() {
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	

	public static void M_1(int N, int idx) {

		if (N == 0) {
			pprint();
		} else {
			for (int i = 1; i <= 6; i++) {
				arr[idx] = i;
				M_1(N - 1, idx + 1);
			}
		}

	}
	

	public static void M_2(int N, int idx) {

		if (N == 0) {
			pprint();
		} else {
			for (int i = arr[idx-1]; i <= 6; i++) {
				if(i==0)
					continue;
				arr[idx] = i;
				M_2(N - 1, idx + 1);
			}
		}

	}
		

	public static void M_3(int N, int idx) {

		if (N == 0) {
			pprint();
		} else {
			for (int i = 1; i <= 6; i++) {
				int btn = 0;
				
				if (idx != 1) {
					for (int j = idx - 1; j > 0; j--) {
						if (arr[j] == i)
							btn = 1;
					}
					if (btn == 1)
						continue;
				}
				
				arr[idx] = i;
				M_3(N - 1, idx + 1);
			}
		}

	}

	public static void solution(int N, int M, int arr[]) {
		arr = new int[N+1];
		if (M == 1) {
			M_1(N, 1);
		}

		if (M == 2) {
			M_2(N, 1);
		}

		if (M == 3) {
			M_3(N, 1);
		}
	}
}
