package Algo.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Z29_DisjointSet {
	
	public static int[] p = new int[10]; // 부모 정보를 담는 배열
	public static int[] rank = new int[10]; // 각 정점의 깊이를 지정할 배열
	
	public static void main(String args[]) throws NumberFormatException, IOException {

		for(int i=0; i<p.length; i++)
			makeSet(i);
		printSet();
		Union(0,1); printSet();
		Union(2,3); printSet();
		Union(0,3); printSet();
		Union(4,5); printSet();
		Union(6,7); printSet();
		Union(3,5); printSet();
		Union(1,8); printSet();
		Union(0,9); printSet();


	}// main
	
	//일반 멤버 x, 일반멤버 y를 포함하는 두집합을 통합
	private static void Union(int x, int y) {
		int px = findSet(x);//x의 대표자를 찾아와라
		int py = findSet(y);//x의 대표자를 찾아와라
		
		//랭크작업에 오류없이하도록
		//같은 집합일 때는 합치지말자 -> 오류시 스택 오버플로
		if(px != py) {
			link(px, py);
			//p[py] = px; //py의 대표자를 px로 한것!			
		}
		
	}

	//x의 대표자 집합, y의 대표자 집합을 rank값 기준으로 합친다. - 깊은 쪽을 대표자로 설정
	private static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = px; // 깊은 쪽을 대표자로 설정
		} else { // rank[px] < rank[py]
			p[px] = py;
			if(rank[px] == rank[py]) { //랭크가 같은 경우 랭크값을 증가
				rank[py]++;
			}
		}
			
	}

	// 일반멤버 x를 포함하는 직합의 대표자를 리턴하는 메소드
	private static int findSet(int x) {
		if(p[x] == x) // 자기 자신을 가지면..?
			return x;
		else { //아니면 자기 부모를 따라가야지!
			return p[x] = findSet(p[x]); //PathComprresion;
		}
	}

	// 멤버 x를 포함하는 새로운 집합을 생성
	private static void makeSet(int x) {
		p[x] = x; // 부모를 자신의 index로 표기
		//rank [x] = 0; // 깊이를 저장, 어차피 0이니 이상없으면 안해도됨.
	}
	
	public static void printSet() {
		//배열인덱
		System.out.print("index : ");
		for(int i : p)
			System.out.printf("%2d ", i);
		System.out.println();
		
		//부모인덱
		System.out.print("parent : ");
		for(int i : p)
			System.out.printf("%2d ", p[i]);
		System.out.println();
		
		//랭크
		System.out.print("rank : ");
		for(int r : rank)
			System.out.printf("%2d ", r);
		System.out.println();
		
		System.out.println();
	}
}// class
