package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac2252_줄세우기_G2_위상정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int M;
	static int cnt;

	static ArrayList<Integer> AL[];//전출되는 대상
	static int arr[];//진입 차수

	static Queue<Integer> Qu = new LinkedList<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());

		//N, M
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			cnt = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			AL = new ArrayList[N + 1];
			arr = new int[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int small_one = Integer.parseInt(st.nextToken());
				int big_one = Integer.parseInt(st.nextToken());
				if (AL[big_one] == null) {
					AL[big_one] = new ArrayList<>();
				}
				AL[big_one].add(small_one);
				arr[small_one]++;
			}

			solution();
			System.out.println("#"+T + " " + sb.toString());
		}
	}

	private static void solution() {
		//일단 다넣고
		for(int i =1; i<=N; i++){
			if(arr[i] == 0)
				Qu.offer(i);
		}
		//arr - 진입
		//AL - 진출


		while(!Qu.isEmpty()) {
			int temp = Qu.poll();
			sb.append(temp).append(" ");
			if(AL[temp] != null) {
				for (int i = 0; i < AL[temp].size(); i++) {
					arr[AL[temp].get(i)]--;
					if (arr[AL[temp].get(i)] == 0) {
						Qu.offer(AL[temp].get(i));
					}
				}
			}
		}
	}
}

