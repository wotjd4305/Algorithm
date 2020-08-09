package Algo.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//반복문
public class Z35_탐욕_연습_회의실 {

	static Point[] arr;
	static Queue<Point> Qu;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	
	static int N;
	static int answer = 0;

	/*
	 * 10 
	 * 1 4 1 6 6 10 4 7 3 8 5 9 3 5 8 11 2 13 12 14
	 */
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		int count = 0;
		int i = 0;
		int flag = 0;
		int idx = 0;
		Qu = new LinkedList<>();		
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new Point[N];
		
		while (st.hasMoreTokens()) {
			arr[idx++] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);

		
		for (int k = 0; k < 10; k++) {
			count = 1;
			i = arr[k].y;
			Qu.add(new Point(arr[k].x, arr[k].y));
			
			while (true) {
				flag = 0;
				
				//지금 선택된 종료시간 보다 큰 애를 찾는 과정
				for (int j = 0; j < 10; j++) {
					if (i <= arr[j].x) {
						Qu.add(new Point(arr[j].x, arr[j].y));
						i = arr[j].y;
						flag = 1;
						count++;
						break;
					}
				}
				
				//더 이상 배치할수가 없으면, 큰애가 없으면 종료
				if(flag == 0) {
					if(answer < count) {
						sb = new StringBuilder("");
						while(!Qu.isEmpty())
						{
							sb.append(Qu.poll().toString() + " ");
						}
						answer = count;
					}
					Qu.clear();
					break;		
				}
			}
		}
		
		System.out.println("회의 시간 일정 : " + sb);
		System.out.println("회의 팀 : " + answer);
		
		
		
	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.y - o.y;
		}

		@Override
		public String toString() {
			return x + "~" + y;
		}

	}

}
