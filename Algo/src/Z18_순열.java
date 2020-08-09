package Algo.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * 순열
 * 
 *
 */

public class Z18_순열 {
	static Scanner sc = new Scanner(System.in);
	public static int[] arr = {1, 3, 5, 7, 9 }; // 순열을 구하고자 하는 원래 배열

	public static void main(String args[]) throws FileNotFoundException {

		int[] a = new int[arr.length]; // 순열의 index(순번)을 저장할 배열.
		backtrack(a, 0, a.length);

	}// main

	// a[] - 배열요소의 사용 유무를 저장할 배열, k : 현재단계, input : 단계의 끝
	public static void backtrack(int[] a, int k, int input) {
		if (k == input) { // 종료파트 -> is_a_Solution()
			process_solution(a, k); // 현재단계에서 만들어낸 부분집합을 출력
		} else { // 재귀 파트
			int[] c = new int[a.length];// 후보군을 담을 배열 : 사용하지 않은 숫자
			int ncands = make_candidates(a, k, input, c);// 후보군의 개수
			// 후보군의 개수만큼 반복, 배열의 원소를 넣고 재귀 호출
			for (int i = 0; i < ncands; i++) {
				a[k] = c[i];
				backtrack(a, k + 1, input);
			}

		}

	}// class

	//c는 사용하지않을..
	private static int make_candidates(int[] a, int k, int input, int[] c) {
		// 사용한 숫자인지 체크할 플래그 변수
		boolean[] in_perm = new boolean[a.length];
		for(int i = 0; i< k; i++) {//현재 단게까지 사용한 숫자
			in_perm[a[i]] = true; 
		}
		
		//
		int ncands = 0;//후보군의 갯수
		for(int i =0; i<in_perm.length; i++) {
			if(!in_perm[i]) {
				c[ncands] = i;
				ncands++;
			}
		}
		
		// 플래그변수에서 false(안체크된)인 숫자를 후보군으로 만들 것.
		return ncands;
	}

	// a배열의 원소를 보고 순열 출력
	private static void process_solution(int[] a, int k) {
		for (int i = 0; i <k; i++) {// K?
				System.out.print(arr[a[i]] + " "); //저장된 순번
		}
		System.out.println();
	}
}// class