package Algo.src;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
입력값
7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51
*/

public class Z31_쿠르스칼_교수님 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int p[];
	static int rank[];

	public static void main(String args[]) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 간선의 배열 사용
		Edge[] G = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			G[i] = new Edge(a, b, val);
		}

		// 정렬이 크루스칼 알고리즘에서 가장 오래 걸리는 부분
		Arrays.sort(G);// N log N -> 카운팅 정렬시 N으로 줄일수 있음

		// 각 정점을 집합으로 만듦
		p = new int[V];
		rank = new int[p.length];
		for (int i = 0; i < p.length; i++) {
			makeSet(i);
		}
		int cnt = 0; // 선택된 간선의 개수
		int MST = 0; // 최소 신장트리 가중치합
		

		// 가중치가 최소인 간선을 선택 V-1개
		for (int i = 0; i < E; i++) {
			Edge e = G[i];
			int px = findSet(e.a);
			int py = findSet(e.b);
			if (px != py) {// 사이클이 생기면 안되요~ 대표자가 다르면
				union(px,py);
				System.out.println(e);//선택된 간선 선택
				cnt++;
				MST += e.val;
				if(cnt == V-1) {
					break;
				}
			}
		}
		
		System.out.println("크루스칼로 구한 MST 전체 가중치합 : " + MST);

	}
	
	public static void union(int px, int py) {
		//link(px, py); // 랭크값을 기준으로 합치자
		if(rank[px] > rank[py]) {//큰쪽은 대표자로 하자
			p[py] = px;
		}
		else {
			p[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
	}

	// x를 포함하는 집합의 대표자
	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		else {
			return p[x] = findSet(p[x]); //PathComprresion;
		}
	}

	// x를 포함하는 새로운 집합 생성
	private static void makeSet(int x) {
		p[x] = x; // 부모 저장
	}

	public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int val;

		public Edge(int a, int b, int val) {
			super();
			this.a = a;
			this.b = b;
			this.val = val;
		}

		// 디버깅이 편함
		@Override
		public String toString() {
			return "(" + a + "," + b + "=" + val;
		}

		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}

	}

}