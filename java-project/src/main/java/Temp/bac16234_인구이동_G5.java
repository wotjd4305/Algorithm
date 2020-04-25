package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac16234_인구이동_G5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int L;
	static int R;

	static int answer;
	static int arr[][];
	static boolean visit[][];

	//상하좌우
	static int dx[] = {-1,1,0,0 };
	static int dy[] = {0,0,-1,1 };

	static Queue<Country> Q;
	static Queue<Country> Q_temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 및 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		Q = new LinkedList<>();
		Q_temp = new LinkedList<>();

		//N
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		//초기화
		arr= new int[N][N];
		visit = new boolean[N][N];
		answer = 0;


		//입력
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}



		solution();
		System.out.println(answer);
	}

	private static void solution() {

		//변경되었니?
		boolean isUpdate;

		while(true){

			//아직 업데이트 안했으니까.
			//끝내는데 사용
			isUpdate = false;

			//다시방문.
			visit = new boolean[N][N];

			//모든 정점을돌아
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(!visit[i][j]){
						int sum = 0;
						int cnt = 0;

						//혹시모르니 초기화
						Q.clear();
						Q_temp.clear();

						Q.add(new Country(i,j,arr[i][j]));
						Q_temp.add(new Country(i,j,arr[i][j]));
						visit[i][j] = true;


						while(!Q.isEmpty()){
							int c_x = Q.peek().x;
							int c_y = Q.peek().y;
							int c_value = Q.poll().value;

							sum += c_value;
							cnt++;

							for(int d=0; d<4; d++){
								int nx = c_x + dx[d];
								int ny = c_y + dy[d];

								if(isRange(nx,ny) && !visit[nx][ny] && isRangeValue(c_value,arr[nx][ny])){
									Q.add(new Country(nx,ny,arr[nx][ny]));
									Q_temp.add(new Country(nx,ny,arr[nx][ny]));
									visit[nx][ny] = true;
								}
							}//d
						}//while

						//while문이 끝나면? Q_t에 값이 있으면,2개이상?
						if(Q_temp.size() >= 2){
							int dived_sum = sum/cnt;

							while(!Q_temp.isEmpty()){
								int c_x = Q_temp.peek().x;
								int c_y = Q_temp.poll().y;
								if(arr[c_x][c_y] != dived_sum)
									isUpdate = true;//하나라도 다르면 업데이트.
								arr[c_x][c_y] = dived_sum;

							}
						}


					}//if
			}//j
			}//i

			//업데이트 안됬으면 끝내.
			if(!isUpdate) break;
			answer++;

		}//while
	}

	public static boolean isRange(int x, int y){
		boolean result = false;
		if(x>=0&&y>=0&&x<N&&y<N){
			result = true;
		}
		return result;
	}

	public static boolean isRangeValue(int c_value, int n_value){
		boolean result = false;
		int dif = Math.abs(c_value - n_value);
		if(L <= dif && dif <= R){
			result = true;
		}
		return result;
	}

	public static class Country{
		int x;
		int y;
		int value;
		Country(int x,int y,int value){
			this.x=x;
			this.y=y;
			this.value=value;
		}
	}
}
