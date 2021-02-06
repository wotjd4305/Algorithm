package TextBook.최단경로;

import java.util.Arrays;

public class Z32_다익스트라 {
	final static int M = Integer.MAX_VALUE;

	public static void main(String args[]) {

		
		int[][] G = {
				{0,3,5,M,M,M},
				{M,0,2,6,M,M},
				{M,1,0,4,6,M},
				{M,M,M,0,2,3},
				{3,M,M,M,0,6},
				{M,M,M,M,M,0}
		};
		
		int s= 0;
		int[] D = G[s];//가중치 배열, 인접행렬의 진출 차수를 기준으로 초기화
		boolean used[] = new boolean[G.length];
		used[s] = true; //시작 정점 선택;
		for(int i = 1; i<used.length; i++) {//정점의 개수만큼 반복, 1사이클에 1정점
			//사용하지 않은 정점 중, D 가중치 배열에서 최소 가중치값 정점을 찾기
			int minIndex = -1;
			int min = M;
			for(int j=0; j<used.length; j++) {
				if(!used[j] && min > D[j]) {
					minIndex = j;
					min = D[j];
				}
			}
			used[minIndex] = true;
			
			//선택한 정점을 통해서 갈수 있는 정점의 가중치를 갱신하기
			for(int j = 0; j< D.length; j++) {
				if(!used[j] && G[minIndex][j] != M && D[j] > D[minIndex] + G[minIndex][i]) {
					D[j] = D[minIndex]  + G[minIndex][j];
				}
			}	
		}
		System.out.println(Arrays.toString(D));
		
	}

}
