package TextBook.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Z21_BFS {

	public static void main(String args[]) {

		int N = 9;
		Queue<Integer> Qu = new LinkedList<>();

		boolean visited[] = new boolean[N];
		boolean side[][] = 
				//A		 B    C    D     E     F     G     H      I
				{{false,true,true,true,false,false,false,false,false},    //A
				{true,false,false,false,true,true,false,false,false},   //B
				{true,false,false,true,false,false,false,false,false},  //C
				{true,false,false,false,true,false,true,true,true},     //D
				{false,true,false,false,false,false,false,false,false}, //E
				{false,true,false,false,false,false,false,false,false}, //F
				{false,false,false,true,false,false,false,false,false}, //G
				{false,false,false,true,false,false,false,false,false}, //H
				{false,false,false,true,false,false,false,false,false}  //I
							};
		
		Qu.offer(0);
		visited[0] = true;
		while (!Qu.isEmpty()) {
			
			int tp = Qu.poll();
			System.out.print((char)(tp + 65) + " ");
			
			
			for (int i = 0; i < N; i++) {
				if ((side[tp][i] || side[i][tp]) && !visited[i]) {
					Qu.offer(i);
					visited[i] = true;
				}
			}
		}

	}
}// class