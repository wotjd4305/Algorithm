package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac1085_정사각형_dfs_델타 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//상하좌우
	static int dx[] = {0,0,1,-1};
	static int dy[] = {-1,1,0,0};

	static int x;
	static int y;
	static int w;
	static int h;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;


		for(int i =0; i<4; i++){
			dfs(x,y, 0,i);
		}

		System.out.println(answer);
	}
	public static void dfs(int cur_x, int cur_y, int cnt, int dic){

		if(cur_x == 0 || cur_x == w || cur_y == 0 || cur_y == h){
			answer = Math.min(answer,cnt);
			return;
		}

		dfs(cur_x+ dy[dic], cur_y + dx[dic], cnt+1, dic);

	}
}
