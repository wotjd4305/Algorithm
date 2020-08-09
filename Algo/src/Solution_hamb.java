package Algo.src;

import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_hamb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();//num of Testcases
		//int TC = 1;
		for (int testcase = 1; testcase <= TC; testcase++) {
			int tp = 0;//토핑
			int cal =0;//칼로리
			int cal_max = 0;
			tp= sc.nextInt();
			cal = sc.nextInt();
			System.out.println();
			int[][]user = new int[10001][2];
			for(int i =0;i < tp; i++) {
				user[i][0] = sc.nextInt(); //음식의 점수
				user[i][1] = sc.nextInt(); //음식의 칼로리
			}
					
			for(int i =0;i < tp; i++) {
				System.out.println(user[i][0] +" "+ user[i][1]);
	
			}
			int  result = 0;
			
			
			while(true)
			//result = findall(tp,cal,user,0,0,0);
			System.out.println(result);
		}
		
		
	}
	
	
	public static int findall(int tp,int cal,int[][] user,int tp_sum,int cal_sum,int result) {
		for(int i = 0;i<tp;i++) {
			if(cal_sum + user[i][1] < cal) { //더해도 칼로리 제한 안 넘을때
				System.out.println(i+"번째 재료 추가");
	
				tp_sum += user[i][0];
				user[i][0] = 0; //음식의 점수
				user[i][1] = cal; //음식의 칼로리
			}
		}
		
		if(result < tp_sum)
			result = tp_sum;
		return result;

	}
}
