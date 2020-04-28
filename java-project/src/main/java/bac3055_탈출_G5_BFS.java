package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class bac3055_탈출_G5_BFS {
	public static class Point {
		int x;
		int y;
		int k;

		public Point(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

		@Override
		public boolean equals(Object o) {
			if(o instanceof Point){
				Point tmp = (Point)o;
				return (x == tmp.x) && ( y == tmp.y) && (k == tmp.k);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return (x +","+y+","+k).hashCode();
		}
	}

	static Queue<Point> Q;

	static int R;
	static int C;
	static Point Dummy = new Point(0,0,0);

	static String[][] Arr_s;
	static int[][] Arr;

	// 동 서 남 북
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		answer = Integer.MAX_VALUE;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Arr_s = new String[R][C];
		Arr = new int[R][C];

		//
		Q = new LinkedList<>();

		for(int i =0; i<R; i++){
				Arr_s[i] = br.readLine().split("");
		}

		//1은 고슴도치
		//2는 물
		//3는 바위
		//4은 해당 굴
		Point temp = null;
		for(int i =0; i<R; i++){
			for(int j=0; j<C; j++) {
				if(Arr_s[i][j].equals("S")) {
					temp = new Point(i,j,1);
					Arr[i][j] = 1;
				}
				else if(Arr_s[i][j].equals("*")) {
					Q.add(new Point(i,j,2));
					Arr[i][j] = 2;
				}
				else if(Arr_s[i][j].equals("X"))
					Arr[i][j] = 3;
				else if(Arr_s[i][j].equals("D"))
					Arr[i][j] = 4;
			}
		}
		Q.add(temp);

		//pprint();

		solution();
		if(answer == Integer.MAX_VALUE) System.out.println("KAKTUS");
		else System.out.println(answer+1);

	}

	public static void solution() {

		Q.add(Dummy);

		int time = 0;
		int idx=0;
		while(!Q.isEmpty()){
			if(Q.peek().equals(Dummy)){
				//pprint();
				time++;
				Q.poll();
				Q.add(Dummy);
				//연속으로 Dummy면 끝
				if(Q.peek().equals(Dummy)){
					return;
				}
			}

			int c_x = Q.peek().x;
			int c_y = Q.peek().y;
			int k = Q.poll().k;

			for(int i=0; i<4; i++){

				int n_x = c_x + dx[i];
				int n_y = c_y + dy[i];

				//범위안이고 방문안했으면
				if(isRange(n_x,n_y) && (Arr[n_x][n_y] == 0 || Arr[n_x][n_y] == 4)) {
					if(Arr[n_x][n_y] == 4){
						//고슴이면
						if(k == 1) {
							answer = time;
							return;
						}
						//물이면
					}
					else {
						Arr[n_x][n_y] = 5;
						Q.add(new Point(n_x, n_y, k));
					}
				}

			}

		}


	}

	public static boolean isRange(int x, int y){
		boolean result = false;
		if(x>=0&&y>=0&&x<R&&y<C){
			result = true;
		}
		return result;
	}

	public static void pprint(){
		for(int i =0; i<R; i++){
			for(int j =0; j<C; j++){
				System.out.print(Arr[i][j]);
			}
			System.out.println();
		}
	}

}
