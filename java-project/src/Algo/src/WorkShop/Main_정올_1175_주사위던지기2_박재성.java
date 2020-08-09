package Algo.src.WorkShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_정올_1175_주사위던지기2_박재성 {
	static Scanner sc = new Scanner(System.in);
	static int arr[];
	static int N;
	static int M;

	public static void main(String args[]) {

		// 던질횟수, 출력형식, 배열
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N + 1];

		solution(N, M, arr);

	}// end of main

	public static void pprint() {

		int sum = 0;
		for (int i : arr)
			sum += i;

		if (sum == M) {
			for (int i = 1; i <= N; i++) {
				if(i==N)
					System.out.print(arr[i]);
				else
					System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
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

	public static void solution(int N, int M, int arr[]) {
		arr = new int[N + 1];
		M_1(N, 1);
	}
}
