package Algo.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*이진트리 
 * 문제 : 추가 조건 설명
 * 		레벨4의 이진트리이다.
 * 		루트의 정점을 1로하자.
 * 전위,중위,후위 순회로 출력.
 * */

//13
//1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
public class Z28_이진트리짜보기 {
	// 0자리는 빼고 할거에요
	// 레벨4 == 높이가 5!, 레벨은 0부터시작
	public static int[] tree = new int[32];// 부족하지않게, 자식을 저장, 0번은 안씀
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws NumberFormatException, IOException {
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 이진트리 저장하기
		tree[1] = 1;
		while (st.hasMoreTokens()) {
			int p = Integer.parseInt(st.nextToken()); // 간선의 시작 정점
			int c = Integer.parseInt(st.nextToken()); // 간선의 끝 정점

			// tree 배열에 부모정점이 있는지 index를 찾자!
			int i = 1;
			for (; i < tree.length; i++) {
				if (tree[i] == p) {

					break;
				}
			}

			// i 위치에 삽입해라!
			if (tree[i * 2] == 0) {// 왼쪽자식이 없으면, 왼쪽으로 등록
				tree[i * 2] = c;
			} else {// 왼쪽자식이 있으면, 오른쪽으로 등록
				tree[i * 2 + 1] = c;
			}

		}
		// 이진트리 순회하기
		System.out.print("\n전위순회 : ");
		preOrder(1);
		System.out.print("\n중위순회 : ");
		inOrder(1);
		System.out.print("\n후위순회 : ");
		postOrder(1);

		System.out.println();
		System.out.println(Arrays.toString(tree));

	}// main

	private static void preOrder(int index) {
		if (index >= tree.length || tree[index] == 0) { // 배열의 범위를 체크, 트리정점이 있는지 체크
			return;
		}

		System.out.print(tree[index] + " ");// 부모 정점 (방문해서 할일 : 출력)
		preOrder(index * 2);// 왼쪽 자식
		preOrder(index * 2 + 1);// 오른쪽 자식

	}

	private static void inOrder(int index) {
		if (index >= tree.length || tree[index] == 0) { // 배열의 범위를 체크, 트리정점이 있는지 체크
			return;
		}

		inOrder(index * 2);// 왼쪽 자식
		System.out.print(tree[index] + " ");// 부모 정점 (방문해서 할일 : 출력)
		inOrder(index * 2 + 1);// 오른쪽 자식

	}

	private static void postOrder(int index) {
		if (index >= tree.length || tree[index] == 0) { // 배열의 범위를 체크, 트리정점이 있는지 체크
			return;
		}

		postOrder(index * 2);// 왼쪽 자식
		postOrder(index * 2 + 1);// 오른쪽 자식
		System.out.print(tree[index] + " ");// 부모 정점 (방문해서 할일 : 출력)

	}

}// class
