package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac2468_안전영역_S1_BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int answer;

	static int arr[][];
	static boolean visited[][];
	static boolean flooded[][];

	//상하좌우
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int cnt=0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N][N];
			flooded = new boolean[N][N];
			cnt = N*N;
			answer = 0;

			for(int i =0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				int idx = 0;
				while(st.hasMoreTokens()){
					arr[i][idx++] = Integer.parseInt(st.nextToken());
				}
			}

			solution();
			System.out.println(answer);

	}

	private static void solution() {

		int level = -1;
		int area = 0;
		Queue<Point> AL = new LinkedList<>();

		while(cnt != 0){
			//
			level++;

			//강물에 빠지게 만들기.
			for(int i =0; i<N; i++){
				for(int j =0; j<N; j++){
					if(arr[i][j] != level) continue;
					flooded[i][j] = true;
					cnt--;
				}
			}
			//pprint();

			//bfs
			visited = new boolean[N][N];
			AL.clear();
			area = 0;
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(!visited[i][j] && !flooded[i][j]){
						area++;
						visited[i][j] = true;
						AL.add(new Point(i,j));

						while(!AL.isEmpty()){
							int c_x = AL.peek().x;
							int c_y = AL.poll().y;
							for(int d=0; d<4; d++) {
								int n_x = c_x + dx[d];
								int n_y = c_y + dy[d];
								if (isRange(n_x,n_y) && !visited[n_x][n_y]  && !flooded[n_x][n_y]){
									visited[n_x][n_y] = true;
									AL.add(new Point(n_x,n_y));
								}//if
							}//for
						}//while
					}//if
				}//for
			}//for

			//System.out.println(level + " - " + area);
			answer = Math.max(answer, area);

		}
	}

	public static boolean isRange(int x, int y){
		boolean result = false;
		if(x>=0 && y>=0 && x<N && y<N){
			result = true;
		}
		return result;
	}

	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void pprint(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(flooded[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}



}

