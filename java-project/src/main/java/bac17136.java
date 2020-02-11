import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bac17136 {

	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Point> AL = new ArrayList<>();

	static int answer = 0;
	static boolean[][] visited;
	static boolean[] idx_visited;
	static int[][] arr;

	static int count[] = new int[6];

	// 색종이는 10x10, 색종이 종류는 N*N 5장씩(N =1,2,3,4,5)
	// 최소한의 색종이 갯수
	public static void main(String[] args) {

		for (int t = 0; t < 1; t++) {

			// 초기화
			answer = 0;
			arr = new int[10][10];
			visited = new boolean[10][10];
			make_arr();
			idx_visited = new boolean[AL.size()];	
			Arrays.fill(count, 0);

			// 솔루션
			solution();

			// 전부다 커버되면 true 아니면 false
			if (!is_covered())
				answer = -1;
			else {
				for (int i : count) {
					answer += i;
				}
			}

			System.out.println(answer);
		}

	}

	public static void solution() {
		//
		int size = count.length - 1;
		for (int i = 0; i < AL.size(); i++) {
			idx_visited[i] = true;
			dfs(size, i);
			idx_visited[i] = false;
		}
	}

	public static void pprint() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}

	// i = 0~(10-size) j = 0~(10-size)
	// 10*10
	//
	public static void dfs(int size, int idx) {

		if (size == 0 || is_covered() || is_ended()) {
			int result = 0;
			for (int i : count) {
				result += i;
			}
			if (is_covered())
				System.out.println("Covered - END -- " + result);
			else
				System.out.println("No - END -- " + result);

			return;
		}

		int cur_x = AL.get(idx).x;
		int cur_y = AL.get(idx).y;
		int btn = 0;

		for (int i = cur_x; i < (cur_x + size); i++) {
			for (int j = cur_x; j < (cur_y + size); j++) {
				if (i < 10 && j < 10) {
					if (visited[i][j]) {
						btn = 1;
						break;
					}
				} else {
					btn = 1;
					break;
				}
			}
			if (btn == 1)
				break;
		}

		if (btn == 0 && count[size] != 5) {
			for (int i = 0; i < AL.size(); i++) {
				if (idx == i)
					continue;
				cover(cur_x, cur_y, size);
				if (!visited[AL.get(i).x][AL.get(i).x] && !idx_visited[i]) {
					idx_visited[i] = true;
					System.out.println(AL.get(i).x + " ---- " + AL.get(i).y);
					dfs(size, i);
					idx_visited[i] = false;
				}
				uncover(cur_x, cur_y, size);
			}
		} 
		else {
					dfs(size - 1, idx);
		}

	}

	// 배열 만들고 큐에 추가!
	public static void make_arr() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int buffer = sc.nextInt();
				if (buffer == 1) {
					AL.add(new Point(i, j));
				}
				arr[i][j] = buffer;
			}
		}
	}

	// 배열리스트를 이용

	public static boolean is_covered() {
		for (Point p : AL) {
			if (!visited[p.x][p.y]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean is_ended() {
		for (boolean b : idx_visited) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	// 색종이로 덮어고 카운터 추가.

	public static void cover(int p_x, int p_y, int size) {
		count[size]++;
		for (int i = p_x; i < 10 && i < (p_x + size); i++) {
			for (int j = p_y; j < 10 && j < (p_y + size); j++) {
				visited[i][j] = true;
			}
		}
	}

	public static void uncover(int p_x, int p_y, int size) {
		count[size]--;
		for (int i = p_x; i < 10 && i < (p_x + size); i++) {
			for (int j = p_y; j < 10 && j < (p_y + size); j++) {
				visited[i][j] = false;
			}
		}
	}

}
