package Algo.src.WorkShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class SWEA_Solution_7234_안전기지_D3_박재성 {

	static Scanner sc = new Scanner(System.in);
	static int N;
	static int B;
	static int arr[][];
	static ArrayList<Point> AL = new ArrayList<>();

	// 동서남북
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;
		int T = sc.nextInt();

		for (int test = 1; test <= T; test++) {

			// 입력및 초기화
			answer = 0;
			N = sc.nextInt();
			B = sc.nextInt();
			AL.clear();
			arr = new int[N + 1][N + 1];
			for (int i = 0; i < B; i++)
				AL.add(new Point((sc.nextInt()), (sc.nextInt())));

			solution();
            
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					answer = Math.max(answer, arr[i][j]);
			bw.write("#" + test + " " + answer +"\n");		
		}
		bw.flush();
		bw.close();
	}

	public static void solution() {

		for (Point p : AL)
			for (int i = 0; i < 4; i++)
				for (int j = 1; j <= 2; j++) {
					int new_x = p.x + j * dy[i];
					int new_y = p.y + j * dx[i];
					if (new_x >= 1 && new_x <= N && new_y >= 1 && new_y <= N) {
						arr[new_x][new_y]++;
					}
				}
	}
}
class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}