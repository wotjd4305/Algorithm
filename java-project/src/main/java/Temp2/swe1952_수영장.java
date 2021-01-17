package main.java.Temp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe1952_수영장 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int answer = 0;
	static int price_arr[];
	static int m_arr[];
	static boolean visited[];

	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			init();
			solution();
			answer = Math.min(price_arr[3], answer);
			System.out.println("#" + (testcase) + " " + answer);
		}
	}

	public static void init() throws IOException {
		answer = Integer.MAX_VALUE;
		price_arr = new int[4]; // 1d, 1m, 3m, y
		m_arr = new int[13];
		visited = new boolean[13];

		StringTokenizer st = new StringTokenizer(br.readLine());
		price_arr[0] = Integer.parseInt(st.nextToken());
		price_arr[1] = Integer.parseInt(st.nextToken());
		price_arr[2] = Integer.parseInt(st.nextToken());
		price_arr[3] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 12; i++)
			m_arr[i] = Integer.parseInt(st.nextToken());

	}

	// 3개씩 조합을 하면될듯?
	public static void solution() {

		visited[1] = true;
		visited[2] = true;
		visited[3] = true;
		Colla(1 + 3);
		visited[1] = false;
		visited[2] = false;
		visited[3] = false;
		Colla(1 + 1);
	}

	public static void Colla(int start) {		
		// true이면 3월짜리로 묶은것이지만, 1월이나 1일로 치는거보다 작으면 그것으로
		if (start >= 13) {
			int result = 0;
			for (int i = 1; i <= 12; i++) {
				
				if (visited[i]) {				
					result += compare(i);
					i +=2;
					continue;
				}
				else
					result += (m_arr[i]*price_arr[0] > price_arr[1])? price_arr[1] : m_arr[i]*price_arr[0];
			}
			if(result != 0) 
				answer = Math.min(answer, result);
			
			return;
		}

		// 범위 안이여야지요
		if (start <= 12) {
			if(start <= 10) {
			visited[start] = true;
			visited[start + 1] = true;
			visited[start + 2] = true;
			Colla(start + 3);
			visited[start] = false;
			visited[start + 1] = false;
			visited[start + 2] = false;
			}
			Colla(start + 1);
		}

	}
	
	public static int compare(int start) {
		int result = 0;
		min = Integer.MAX_VALUE;
		
		//3달짜리
		result = price_arr[2];
		min = Math.min(min, result);
		
		return min;
		
	}
	
	//이어진 세개 중, 1일로 계산 혹은 한달로 계산중 뭐가 더 싼지.
	public static void compare_d1(boolean[] visited_d1, int count, int start) {
		
		if(count == 3) {
			int result = 0;
			for(int i=0; i<=2; i++) {
				if(visited_d1[i])
					result +=  m_arr[start+i]*price_arr[0];
				else
					result += price_arr[1];
			}
			if(result != 0)
				min = Math.min(min, result);
			return;
		}
		
		visited_d1[count] = true;
		compare_d1(visited_d1, count +1, start);
		visited_d1[count] = false;
		compare_d1(visited_d1, count +1, start);
	
	}
}
