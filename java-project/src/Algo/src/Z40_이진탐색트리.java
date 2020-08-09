package Algo.src;

import java.util.Arrays;
/*
input
8
9 4 12 15 6 13 3 17
4 
13
9
15
0
*/
import java.util.Scanner;

//편향 안되요~
public class Z40_이진탐색트리 {
	public static int[] BST; // 이진탐색트리
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점의 총 개수, 정점번호는 양수만, 0은사용x, 1<=N<=31
		BST = new int[1 << (N + 1)];

		for (int i = 0; i < N; i++) {
			insert(sc.nextInt());// 이진에 추가하는 과정.

		}
		print();
		delete(4); //노드 삭제
		delete(13); //노드 삭제
		delete(9); //노드 삭제
		delete(15); //노드 삭제
	
		print();

	}
	
	//num번호 숫자의 정점을 찾아서 삭제, 없으면 블기
	public static void delete(int num) {
		int node = search(num);
		if(node > 0) {//존재
			deleteNode(node);
		}
		else {//존재못함
			System.out.println("[에러] 이진탐색트리에 " + num + "값은 존재하지 않아요.");
		}
	}
	
	//존재가 확인된 노드를 node(index) 위치 정점 삭제
	public static void deleteNode(int node) {
		
		if(node*2+1 < BST.length && BST[node*2] == 0 && BST[node*2+1] == 0) {//차수가 0일경우, 아주간단
			BST[node] = 0;//삭제
		}
		else if(node*2 < BST.length && BST[node*2] != 0 && BST[node*2+1] == 0) {//차수가 1인데, 좌측 자식 존재
			//좌측 서브트리의 가장 큰값의 index 찾아서(삭제), node자리에 삽입
			int subNode = findmax(node*2);
			BST[node] = BST[subNode];//찾아온거 삭제.
			deleteNode(subNode);
		//}
		}else {//차수가 2인경우, 위에꺼 아무거나 선택하면되요.
		//else if(node*2+1 < BST.length && BST[node*2] == 0 && BST[node*2+1] != 0 ) {//차수가 1인데. 우측 있으면
			//좌측 서브트리의 가장 작은값을 찾아서(삭제), node자리에 삽입
			int subNode = findmin(node*2+1);
			BST[node] = BST[subNode];//찾아온거 삭제.
			deleteNode(subNode);
			
		}
	}

	//가장 작은값, 즉 가장 좌측인것을 찾으면됨.
	private static int findmin(int node) {
		if(node*2 < BST.length && BST[node*2] != 0)
			node = findmax(node*2);
		return node;
	}

	//노드 정점을 루트로 하는 subTree의 가장 큰 값을 찾아서 index리턴.
	//가장 우측인걸 찾으면됨. 오른쪽으로 쭈욱
	private static int findmax(int node) {
		if(node*2+1 < BST.length && BST[node*2+1] != 0)
			node = findmax(node*2+1);
		return node;
	}

	//노드출력 중위순회 호출
	public static void print() {
		
		System.out.print("\n중위순회 : ");
		inOrder(1);
		System.out.println();
	}
	
	//중위순회, 오름차순
	private static void inOrder(int node) {
		if(node >= BST.length || BST[node] == 0) return;
		inOrder(node*2);
		System.out.print(BST[node] + " ");
		inOrder(node*2+1);
	}
	
	private static void insert(int num) {
		// 삽입할 위치는 검색, 존재하는 경우 삽입 불가, 검색 실패해야 가능.
		int node = search(num);
		if (node > 0) { // 존재
			System.out.println("[에러] 이진검색트리에는 중복값을 저장할수없음 : " + num);
		} else { // 존재하지 않음
			BST[-node] = num;
		}

	}

	// BST 에서 num 값을 찾으면 index 리턴, 못찾으면 삽입해야할 위치 index를 음수리턴.
	private static int search(int num) {
		int node = 1; // 루트 인덱스
		while (node < BST.length && BST[node] != 0) {// 길이안이고&&
			if (num == BST[node]) {
				return node;
			} else if (num < BST[node]) {// 작으면 왼쪽
				node = node * 2;
			} else {// 크면 오른쪽으로
				node = node * 2 + 1;
			}
		}
		return -node;
	}
}
