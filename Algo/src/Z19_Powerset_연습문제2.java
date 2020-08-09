package Algo.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

//바이너리 카운팅으로 하자.
public class Z19_Powerset_연습문제2 {
	static Scanner sc = new Scanner(System.in);
	public static int[] arr = { 1, 2, 3, 4, 5, 6, 7 }; // 부분집합을 구하고자 하는 원래 배열

	public static void main(String args[]) throws FileNotFoundException {

		boolean[] a = new boolean[arr.length];
		backtrack(a, 0, a.length, 0);

	}// main

	// a[] - 배열요소의 사용 유무를 저장할 배열, k : 현재단계, input : 단계의 끝, sum : 지금까지 선택된 부분집합 원소의
	// 합.
	public static void backtrack(boolean[] a, int k, int input, int sum) {
		if (k == input) { // 종료파트 -> is_a_Solution()
			if (sum == 10)
				process_solution(a, k); // 현재단계에서 만들어낸 부분집합을 출력
		} else { // 재귀 파트
			boolean[] c = new boolean[2];// 후보군(사용할지 안할지)을 담을 배열 true, false
			int ncands = make_candidates(a, k, input, c);// 후보군의 개수
			// 후보군의 개수만큼 반복, 배열의 원소를 넣고 재귀 호출
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				int nextSum = sum + (a[k] ? arr[k] : 0);
				if (nextSum <= 10) {
					backtrack(a, k + 1, input, nextSum);
				}
			}

		}

	}// class

	// 후보군 배열을 셋팅후 후보군 개수를 리턴
	private static int make_candidates(boolean[] a, int k, int input, boolean[] c) {
		c[0] = false;
		c[1] = true;
		return 2;
	}

	// a배열의 원소 사용여부를 보고 출력
	private static void process_solution(boolean[] a, int k) {
		for (int i = 0; i < a.length; i++) {
			if (a[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();

	}
}// class