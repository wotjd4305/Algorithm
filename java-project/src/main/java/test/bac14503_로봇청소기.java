import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac14503_로봇청소기 {

	//북 동 남 서
	//서 북 동 남
	// 방향에 대한 왼쪽
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	// 방향에 대한 후진
	static int[] bx = {1, 0, -1, 0};
	static int[] by = {0, -1, 0, 1};
	static int[][] matrix;

	static int flag=0;

	// 청소 카운트
	static int cnt = 0;
	static int N; static int M;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		//초기화
		matrix = new int[N][M];
		visit = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			String[] map = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(map[j]);
				matrix[i][j] = tmp;
				if(tmp == 1) visit[i][j] = true;
			}
		}
		clean(x, y, d);
	}

	public static void clean(int x, int y, int d) {

		if(flag==1) return;
		//위치청소
			if (!visit[x][y]) {
				visit[x][y] = true;
				cnt++;
			}

		int turn_cnt=0;
		//4면이 어때요?
		for(int i=0; i<4; i++){
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			if(new_x >=0 && new_x < N && new_y >= 0 && new_y < M) {
				if (visit[new_x][new_y] || matrix[new_x][new_y] == 1)
					turn_cnt++;
			}
		}

		//c | d. 네방향 ㅗㅁ두 청소가 되있거나 벽인경우
		if(turn_cnt == 4) {
			int backX = x + bx[d];
			int backY = y + by[d];
			//범위 안이고
			if(backX >= 0 && backX < N   && backY >= 0 && backY < M) {
				//뒤쪽 벽..
				if(matrix[backX][backY] == 1) {
					System.out.println(cnt);
					flag =1;
					return;
				}
					clean(backX, backY, d);
			}
		}

		// 진행방향 왼쪽 좌표
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (d == 0) d = 3;
		else d = d - 1;

		//범위 안이며
		if(nx >= 0 && nx < N  && ny >= 0 && ny < M) {
				//a. 왼쪽방향에 청소안헀으면 1번으로
				if (!visit[nx][ny]) clean(nx, ny, d);
				//b. 청소공간 없음 방향을 회전하고 2번으로
				else clean(x, y, d);
		}
	}
}