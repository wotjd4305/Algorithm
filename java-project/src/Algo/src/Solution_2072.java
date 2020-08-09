package Algo.src;

import java.util.Scanner;

public class Solution_2072{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();//num of Testcases
		for (int testcase = 1; testcase <= TC; testcase++) {
			int tmp = 0;
            int sum = 0;
            for(int i =0;i<10;i++){
            	tmp = sc.nextInt();
                if(tmp%2==1)
                    sum+=tmp;
            }
            System.out.println("#"+ testcase+ " "+ sum);
						
		}
		
	}
}
