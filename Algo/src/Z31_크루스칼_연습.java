package Algo.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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


public class Z31_크루스칼_연습 {
	
	public static int[] p = new int[7]; // 부모 정보를 담는 배열
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Pair> AL = new ArrayList<>();
		
		//입력후 정렬
		for(int i =0; i<11; i++) {
			AL.add(new Pair(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(AL);
		
		//SET만들기
		for(int i=0; i<p.length; i++)
			makeSet(i);
		
		//Solution
		printSet();
		for(Pair t : AL) {
			Union(t.src, t.dst); //printSet();
			int btn = 0;
			for(int i : p)
				if(p[i] != 0)
					btn = 1;
			
			if(btn == 0) {
				//System.out.println(t.src + " - " + t.dst);
				break;
			}
		}		
	}
	
	// 멤버 x를 포함하는 새로운 집합을 생성
		private static void makeSet(int x) {
			p[x] = x; // 부모를 자신의 index로 표기
			//rank [x] = 0; // 깊이를 저장, 어차피 0이니 이상없으면 안해도됨.
		}
		
		
		
		//일반 멤버 x, 일반멤버 y를 포함하는 두집합을 통합
		private static void Union(int x, int y) {
			int px = findSet(x);//x의 대표자를 찾아와라
			int py = findSet(y);//x의 대표자를 찾아와라
			
			//랭크작업에 오류없이하도록
			//같은 집합일 때는 합치지말자 -> 오류시 스택 오버플로
			if(px != py) {
				p[py] = px; //py의 대표자를 px로 한것!
				System.out.println(x + " - " + y);
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
		}
	
	
	
}

class Pair implements Comparable<Pair>{
	int src;
	int dst;
	int value;
	
	public Pair(int src, int dst, int value) {
		this.src = src;
		this.dst = dst;
		this.value = value;
	}

	@Override
	public int compareTo(Pair o) {
		return this.value - o.value;	
	}
	
}
