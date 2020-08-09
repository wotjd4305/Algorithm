package Algo.src.WorkShop;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 서울_11반_박재성 {
	
	static int StarA[][];//별 넣을 배열
	static boolean Visit[][];//별자리완성 배열
	static int N = 10;

	static int answer;

	//8방향
	//북 북동 동 동남 남 남서 서 서북
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,1,1,1,0,-1,-1,-1};

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine().trim());//테케 입력, 공백 제거(txt에 공백존재)

		for (int testcase = 1; testcase <= TC; testcase++) {//테스트만큼 반복

			//초기화
			answer = 0;
			StarA = new int[N][N];//N만큼 초기화
			Visit = new boolean[N][N];//N만큼 초기화

			//한줄씩 토큰으로 입력
			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());//한줄가져와서 토큰으로만듬
				int idx = 0;
				while(st.hasMoreTokens()){//토큰이 있으면 반복
					StarA[i][idx++] = Integer.parseInt(st.nextToken());//토큰가져와서입력
				}
			}

			bfs_brute();//BFS랑 완탐으로 풀 예정
			System.out.println("#" + testcase + " " + answer);
		}
	}

	public static void bfs_brute(){
		Queue<Point> Q = new LinkedList<>();
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++){
				//별이 있으면
				if(StarA[i][j] == 1 && !Visit[i][j]){
					answer++;
					Q.clear();//새로운 Que를 돌려야해서 새 할당보다는 clear

					Q.add(new Point(i,j));
					Visit[i][j] = true;

					while(!Q.isEmpty()) {
						int c_x = Q.peek().x;
						int c_y = Q.poll().y;
						for (int d = 0; d < 8; d++) {
							int n_x = c_x + dx[d];
							int n_y = c_y + dy[d];
							if (isRange(n_x,n_y) && StarA[n_x][n_y] == 1 && !Visit[n_x][n_y]) {
								Visit[n_x][n_y] = true;
								Q.add(new Point(n_x, n_y));
							}
						}
					}
				}
			}
		}
	}

	//배열 범위안인지
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
}
