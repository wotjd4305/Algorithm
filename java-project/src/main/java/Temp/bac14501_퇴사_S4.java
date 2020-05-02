package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac14501_퇴사_S4 {
	static int N, answer =0;
	static int T[],P[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		T = new int[N+1];
		P = new int[N+1];

		for(int i =1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		Comp(1,0);
		System.out.println(answer);
	}

	private static void Comp(int start, int sum) {
		for(int i =start; i<=N; i++) {
			if(i+T[i] > N+1){
				answer = Math.max(answer, sum);
				continue;
			}
			if(i+T[i] == N+1){
				answer = Math.max(answer, sum+P[i]);
				continue;
			}
			Comp(i + T[i], sum + P[i]);
		}
	}
}
