package main.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bac1018_체스판다시칠하기_완탐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int answer1;
	static int answer2;
	static int answer;
	static int tmp;

	static String arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new String[N][M];
		answer1 = 0;
		answer2 = 0;
		answer = Integer.MAX_VALUE;
		tmp = Integer.MAX_VALUE;

		for(int i = 0;  i<N; i++) arr[i] = br.readLine().split("");

		//0 1 2 3 4 5 6 7
		//1 2 3 4 5 6 7 8
		//2 3 4 5 6 7 8 9
		for(int i=0; i<=(N-8); i++){
			for(int j=0; j<=(M-8); j++){
				answer1 = 0;
				answer2 = 0;
				for(int k=i; k<i+8; k++) {
					for(int l=j; l<j+8; l++) {
						if (arr[k][l].charAt(0) != (((k + l) % 2 == 0) ? "W" : "B").charAt(0))
							answer1++;
						if (arr[k][l].charAt(0) == (((k + l) % 2 == 0) ? "W" : "B").charAt(0))
							answer2++;
					}
				}
				tmp = Math.min(answer1,answer2);
				answer = Math.min(tmp,answer);
			}
		}
		System.out.println(answer);
	}
}
