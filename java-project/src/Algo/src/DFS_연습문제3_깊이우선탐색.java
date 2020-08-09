package Algo.src;

import java.util.Scanner;
import java.util.Stack;

public class DFS_연습문제3_깊이우선탐색 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {

		int[][] arr = { // 그래프 저장 - 인접행렬
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0 }, // 1번
				{ 0, 1, 0, 0, 1, 1, 0, 0 }, // 2번
				{ 0, 1, 0, 0, 0, 0, 0, 1 }, // 3번
				{ 0, 0, 1, 0, 0, 0, 1, 0 }, // 4번
				{ 0, 0, 1, 0, 0, 0, 1, 0 }, // 5번
				{ 0, 0, 0, 0, 1, 1, 1, 1 }, // 6번
				{ 0, 0, 0, 1, 0, 0, 1, 0 },// 7번
		};

		int[] stack = new int[100];// 이전 갈림길을 가기위한 스택.
		boolean[] visited = new boolean[arr.length]; // 방문여부
		int top = -1;

//DFS 순회
		int v = 1;// 시작 정점 지정
		visited[v] = true;// 정점 방문체크(Visited)
		stack[++top] = v;// 스택에 넣기
		System.out.print(v + " ");// 방문해서 할일(정점 번호 출력)

		while (top > -1) {// 스택이 비워질때까지 반복
			int w = -1;//다음 갈 정점을 저장할 변수
			for (int i = 1; i < arr.length; i++) {// 반복문
				if (arr[v][i] == 1 && !visited[i]) {// 인접한 정점 찾기, 미방문정점 찾기
					w = i;
					visited[w] = true;
					stack[++top] = w;
					System.out.print(w + " ");
					v = w;
					break;
				}
			}
			if(w ==-1) {//못찾았으면
				v = stack[top--];
			}
		}

		/*
		 * boolean visited[] = new boolean[8]; boolean side[][] = new boolean[8][8];
		 * Stack<Integer> st = new Stack<>();
		 * 
		 * // 초기 간선 초기화 side[1][2] = true; side[2][1] = true; side[1][3] = true;
		 * side[3][1] = true; side[2][4] = true; side[4][2] = true; side[2][5] = true;
		 * 
		 * //역도 같이 초기화 side[5][2] = true; side[4][6] = true; side[6][4] = true;
		 * side[5][6] = true; side[6][5] = true; side[6][7] = true; side[7][6] = true;
		 * side[3][7] = true; side[7][3] = true;
		 * 
		 * // st.push(1); visited[1] = true;
		 * 
		 * while (!st.isEmpty()) { int start_idx = st.pop();
		 * System.out.println(start_idx);
		 * 
		 * for (int i = 1; i <= 7; i++) { if (start_idx == i) continue; if
		 * (side[start_idx][i] == true) if (visited[i] == false) { st.push(i);
		 * visited[i] = true;
		 * 
		 * } }
		 * 
		 * }
		 */

	}//main
}//class
