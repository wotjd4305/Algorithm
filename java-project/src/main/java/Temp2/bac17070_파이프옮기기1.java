package main.java.Temp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac17070_파이프옮기기1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 0 1 2 3 4 | 빈칸 빈칸 오른쪽, 오른아래, 아래
	static int dx[] = { 0, 0, 1, 1, 0 };
	static int dy[] = { 0, 0, 0, 1, 1 };
	static int N;
	static int arr[][];

	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];

		// 입력받아 배열
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = 1;
			while (st.hasMoreTokens()) {
				arr[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}

		solution();
		System.out.println(answer);
	}

	// 2, 3, 4 | 오, 오아, 아
	public static void solution() {
		arr[1][1] = 1;
		arr[1][2] = 2;
		dfs(1, 3, 2);
		dfs(2, 3, 3);
	}

	public static void dfs(int x, int y, int dir) {

		// 목적지 도착이면 끝
		if (x == N && y == N) {
				answer++;
				arr[x][y] = 0;
				return;
			}

		
		// 범위밖이면 out, 이미 지나왔던곳이면 out, 대각선 일경우
		if (!(x >= 1 && y >= 1 && x <= N && y <= N))
			return;
		if (dir == 3 && (arr[x-1][y] != 0 || arr[x][y-1] != 0))
			return;
		if (arr[x][y] != 0)
			return;		

		// 위에 조건에 안걸리면 방문 찍고.
		if(dir == 3) { arr[x-1][y] = 3; arr[x][y-1] = 3; }
		arr[x][y] = dir;

		// 2, 3, 4 | 오, 오아, 아
		switch (dir) {
			case 2:
				dfs(x + dy[dir], y + dx[dir], dir);
				dfs(x + dy[dir + 1], y + dx[dir + 1], dir+1);
				break;
			case 3:
				dfs(x + dy[dir-1], y + dx[dir-1], dir-1);
				dfs(x + dy[dir], y + dx[dir], dir);
				dfs(x + dy[dir + 1], y + dx[dir + 1], dir+1);
				break;
			case 4:
				dfs(x + dy[dir], y + dx[dir], dir);
				dfs(x + dy[dir - 1], y + dx[dir - 1], dir-1);
				break;
		}
		
		//끝나면 방문 끝내고
		if(dir == 3) { arr[x-1][y] = 0; arr[x][y-1] = 0; }
		arr[x][y] = 0;
	}

}
