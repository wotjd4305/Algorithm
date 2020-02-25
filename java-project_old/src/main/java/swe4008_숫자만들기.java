package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe4008_숫자만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int answer = 0;
	static int answer_Max;
	static int answer_Min;
	static int N;

	static int op_num_arr[];
	static String op_arr[];
	static int num_arr[];

	// Main
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			init();
			solution();
			answer = answer_Max - answer_Min;
			System.out.println("#" + (testcase) + " " + answer);
		}
	}

	// N - 사용되는 숫자 수.
	public static void init() throws IOException {

		// 초기화
		answer = 0;
		answer_Max = Integer.MIN_VALUE;
		answer_Min = Integer.MAX_VALUE;

		N = Integer.parseInt(br.readLine());

		op_num_arr = new int[4];
		num_arr = new int[N];
		int idx = 0;

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		op_num_arr[0] = Integer.parseInt(st.nextToken());
		op_num_arr[1] = Integer.parseInt(st.nextToken());
		op_num_arr[2] = Integer.parseInt(st.nextToken());
		op_num_arr[3] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			num_arr[idx++] = Integer.parseInt(st.nextToken());

		// visited 초기화
		int size = 0;
		for (int i = 0; i <= 3; i++)
			size += op_num_arr[i];

		//
		idx = 0;
		op_arr = new String[size];

		// + - * /
		while (true) {
			for (int j = 0; j < op_num_arr[0]; j++) {
				op_arr[idx++] = "+";
			}
			for (int j = 0; j < op_num_arr[1]; j++) {
				op_arr[idx++] = "-";
			}
			for (int j = 0; j < op_num_arr[2]; j++) {
				op_arr[idx++] = "*";
			}
			for (int j = 0; j < op_num_arr[3]; j++) {
				op_arr[idx++] = "/";
			}
			break;
		}
	}

	// Solution
	public static void solution() {
		DFS(0, num_arr[0]);
	}

	// DFS
	public static void DFS(int count, int total) {
		if (count == op_arr.length) {
			answer_Min = Math.min(answer_Min, total);
			answer_Max = Math.max(answer_Max, total);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op_num_arr[i] > 0) {
				op_num_arr[i]--;

				switch (i) {
				case 0:
					DFS(count + 1, total + num_arr[count + 1]);
					break;
				case 1:
					DFS(count + 1, total - num_arr[count + 1]);
					break;
				case 2:
					DFS(count + 1, total * num_arr[count + 1]);
					break;
				case 3:
					DFS(count + 1, total / num_arr[count + 1]);
					break;
				}
				op_num_arr[i]++;
			}
		}
	}
}
