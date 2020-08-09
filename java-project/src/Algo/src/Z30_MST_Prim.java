package Algo.src;

import java.io.IOException;
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



public class Z30_MST_Prim {

	public static void main(String args[]) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] G = new int[V][V]; // 인접행렬, 초기값 0!
		for(int i = 0; i < E; i++) {
			int parent = sc.nextInt();
			int index = sc.nextInt();
			int value = sc.nextInt();
			G[parent][index] = G[index][parent] = value;
			
		}
		
		int[] p = new int[G.length]; // 부모 인덱스, st, 파이
		int[] val = new int[G.length]; // 최소 가중치를 저장할배열, val, key
		
		//시직할 정점 지정(어던정정저이 와도 결과 동일0
		int index = 0;
		for(int i = 0; i<G[index].length; i++) {
			if(G[index][i]>0){
				p[i] = index;
				val[i]= G[index][i];
			}else {
				p[1] = 1;
				val[i] = Integer.MAX_VALUE;
				
			}
		}
		
		p[index] = index;
		val[index] = -1;
		boolean[] selected = new boolean[V];
		//시작정점 표시
		selected[index] = true;
		
		for(int i=1; i<V; i++) {//정점이 계쏙 추가될것, 간선의 개수 N-1
								//한사이클마다 정점 1개 선택
			// 선택하지 않은 정점 중에서 가중치가 최소인 정점을 찾는다.
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int j = 0; j<val.length; j++) {
				if(!selected[j] && min > val[j]) {
					min = val[j];
					minIndex = j;
				}
			}
			index = minIndex; //최소 가중치 정점을 선택.
			selected[index] = true;
			
			// 선택한 정점을 출력(정점1 - 정점2 가중치) 
			System.out.println(p[index] + "-" + index + " " + val[index]);
			
			// 새로 선택한 정점을 통해서 개척된 새로운 경로를 업데이트(부모, 가중치)
			for(int j=0; j< G[index].length; j++) {
				//선택하지 않은 정점 중, 인접했고, 가중치가 더 작으면 업데이트
				if(!selected[j] && G[index][j] > 0 && val[j] > G[index][j]) {
					p[j] = index; // 부모 업데이트
					val[j] = G[index][j];
				}
			}
			
		}
		
		//MST합을 출력
		int MST = 0;
		for(int i = 0; i< val.length; i++) {
			MST += val[i];
		}
		System.out.println("Prim으로 구한 MST의 전체 가중치 합 : " + MST);
	}// main	
}// class
