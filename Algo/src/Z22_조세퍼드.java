package Algo.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Z22_조세퍼드 {
	public static void main(String args[]) {

		//교수님
		LinkedList<Integer> list = new LinkedList<>();
		for(int i =0; i<24; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		int index = 0;
		while(true)
		{
			if(index >= list.size())
				index %= list.size();
			if(list.size() == 2)
				break;
			
			list.remove(index);
			index = index +2;
		}
		
			System.out.println(list);
		
		
		
		//Queue로 해결
		/*Queue<Integer> Qu = new LinkedList<>();
		
		//입력
		for (int i = 0; i < 24; i++)
			Qu.add(i);

		//처음에 죽이고 두명넘기기
		while (Qu.size() != 2) {
			System.out.print(Qu.peek() + " ");
			Qu.remove();
			Qu.add(Qu.poll());
			Qu.add(Qu.poll());
		}

		System.out.println();
		while (!Qu.isEmpty()) {
			System.out.print(Qu.poll() + " ");
		}
		
		*/
		
		
		
		
		
		
	}
}// class
