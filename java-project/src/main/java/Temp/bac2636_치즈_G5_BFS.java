package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac2636_치즈_G5_BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int R;
	static int C;

	//정답
	static int cnt;
	static int total;

	static int arr[][];
	static boolean visit[][];

	//상하좌우
	static int dx[] = {-1,1,0,0 };
	static int dy[] = {0,0,-1,1 };

	static Queue<Point> Q;
	static ArrayList<Point> AL;


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());

		//N
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		//초기화
		Q = new LinkedList<>();
		arr= new int[R][C];
		visit = new boolean[R][C];


		//입력
		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}


		solution();
		System.out.println(cnt);
		System.out.println(total);
	}

	private static void solution() {

		AL = new ArrayList<>();
		BFS(0,0);

		cnt = 0;
		total = 0;

		while(!AL.isEmpty()){
			total =0;
			cnt++;
			for(Point p : AL){
				arr[p.x][p.y] = 0;
				total++;
			}
			AL.clear();
			BFS(0,0);
		}

	}

	public static void BFS(int x, int y){

		//초기화
		Q.clear();
		visit = new boolean[R][C];

		Q.add(new Point(x,y));
		while(!Q.isEmpty()){

			int cx = Q.peek().x;
			int cy = Q.poll().y;
			visit[x][y] = true;

			for(int i=0; i<4; i++){
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(isRange(nx,ny) && !visit[nx][ny]){
					if(arr[nx][ny] == 0) {
						Q.add(new Point(nx, ny));
					}
					else{
						AL.add(new Point(nx,ny));
					}
					visit[nx][ny] = true;
				}

			}

		}

	}

	public static void pprint(){
		for(int i=0; i<R; i++){
			for(int j =0; j<C; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean isRange(int x, int y){
		boolean result = false;
		if(x>=0 && y>=0 && x<R && y<C){
			result = true;
		}
		return result;
	}

	public static class Point{
		int x;
		int y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
