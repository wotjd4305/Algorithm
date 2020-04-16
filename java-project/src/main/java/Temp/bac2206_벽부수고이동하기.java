package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac2206_벽부수고이동하기 {

	static int N;
	static int M;
	static String arr[][];
	static int visited[][][];

	static int answer;

	//북 동 남 서
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		//초기화
		arr = new String[N][M];
		visited = new int[N][M][2];
		answer = Integer.MAX_VALUE;

		//입력
		for(int i =0; i<N; i++){
			arr[i] = br.readLine().split("");
		}

		for(int i=0; i<N; i++){
			for(int j =0; j<M; j++){
				visited[i][j][0] = Integer.MAX_VALUE;
				visited[i][j][1] = Integer.MAX_VALUE;
			}
		}

		bfs();
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}

	public static void bfs(){

		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(0,0,1,0));
		//0은 벽을 부수고 온것, 1은 안부수고 온것
		visited[0][0][0] = 1;
		visited[0][0][1] = 1;

		while(!Q.isEmpty()) {

			Point tmp = Q.poll();
			boolean isCrashed = (tmp.count > 0)? true : false;

			//종료 조건
			//도착할곳에 도착했는가
			if (tmp.x == N - 1 && tmp.y == M - 1) {
				//System.out.println("도착 : " + tmp.dis);
				answer = Math.min(answer, tmp.dis);
				return;
			}

			//반복
			//동서남북
			//벽을 부수거나 안부수거나..
			for (int i = 0; i < 4; i++) {
				int n_x = tmp.x + dx[i];
				int n_y = tmp.y + dy[i];

				if(!isRange(n_x,n_y)) continue;
				if(!isCrashed && visited[n_x][n_y][0] <= tmp.dis+1) continue;
				if(isCrashed && visited[n_x][n_y][1] <= tmp.dis+1) continue;

				//벽일
				if(arr[n_x][n_y].equals("1")){
					//한번도 안 뚫어봐야
						if(!isCrashed && visited[n_x][n_y][0] == Integer.MAX_VALUE){
						visited[n_x][n_y][1] = tmp.dis+1;
						Q.add(new Point(n_x,n_y,tmp.dis+1, tmp.count+1));
						}
						//만약 뚫려있기만 하면 가긴가야지?
						else if(!isCrashed && visited[n_x][n_y][0] != Integer.MAX_VALUE){
							visited[n_x][n_y][0] = tmp.dis+1;
							Q.add(new Point(n_x,n_y,tmp.dis+1, tmp.count+1));
						}
				}
				//아닐떄
				else{
					//박살낸 애가 간거랑 안박살난애가 간거는 달라야함.
					if(isCrashed) visited[n_x][n_y][1] = tmp.dis+1;
					else visited[n_x][n_y][0] = tmp.dis+1;
					Q.add(new Point(n_x,n_y,tmp.dis+1,tmp.count));
				}
			}
		}

	}

	public static boolean isRange(int x, int y){
		boolean result = false;
		if(x >= 0 && x<N && y >=0 && y<M){
			result = true;
		}
		return result;
	}

	public static class Point{
		int x;
		int y;
		int dis;
		int count;
		Point(int x, int y,int dis, int count){
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.count = count;
		}
	}

}
 