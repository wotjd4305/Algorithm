package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bac10844_쉬운계단의수_DP {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static final long Div = 1000000000;
	static int N;
	static long answer;
	static long Arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		N = Integer.parseInt(br.readLine());

		//초기화, DP 밑작업
		Arr = new long[N+1][10];
		Arr[0][1] = 1;
		for(int i=1; i<=9; i++) Arr[1][i] = 1;

		//2부터
		for(int i=2; i<=N; i++){
			for(int j=1; j<=9; j++){
				//1일경우 그 밑수는 0과 2
				//0은 1의 값과 같다
				if(j==1){
					//차례대로 0(= 1)과 2
					Arr[i][j] = (Arr[i-2][j] + Arr[i-1][j+1]) % Div;
				}
				//9일경우 밑수는 8만 존재..
				else if(j==9){
					Arr[i][j] = Arr[i-1][j-1] % Div;
				}
				//2,3,4,5,6,7,8
				else{
					Arr[i][j] = (Arr[i-1][j-1] + Arr[i-1][j+1]) % Div;
				}
			}
		}
		for(long i : Arr[N]){
			answer += i;
		}
		//System.out.println(Arrays.toString(Arr[N]));
		System.out.println(answer % Div);
	}
}
