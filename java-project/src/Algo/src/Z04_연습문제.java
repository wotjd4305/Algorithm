package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

/** �������� */
public class Z04_연습문제 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int dx[] = {0,0,-1,1};
		int dy[] = {-1,1,0,0};
		
		int arr[][] = new int[5][5];
		int answer[][] = new int[5][5];
		int result = 0;
		
		int idx = 0;
		
		for(int i =0; i<5; i++)
			for(int j=0; j<5; j++)
				arr[i][j] = idx++;
		
		for(int i =0; i<5; i++)
			for(int j=0; j<5; j++)
			{
				for(int k=0; k<4; k++)
				{
					if(((i+dx[k]) >=0 && (i+dx[k]) < 5 ) && 
							((j+dy[k]) >=0 && (j+dy[k]) <5))
						answer[i][j] += Math.abs( arr[i][j] - arr[i + dx[k]][j + dy[k]]); 
				}
				result += answer[i][j];
			}
		
		
		for(int i =0; i<5; i++) {
			for(int j=0; j<5; j++)
				System.out.format("%3d ",answer[i][j]);
			System.out.println();
		}
		
		System.out.println();
		for(int i =0; i<5; i++) {
			for(int j=0; j<5; j++)
				System.out.format("%3d ",arr[i][j]);
			System.out.println();
		}
		System.out.println(result);
		
		
		
		
		
	}// end of main

}// end of class
