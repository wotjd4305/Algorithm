package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1204 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				
				int TC = sc.nextInt();//num of Testcases
				//int TC = 1;
				int tt;
				for (int testcase = 1; testcase <= TC; testcase++){
					tt = sc.nextInt();
					int arr[] = new int[1000];
					for(int i =0;i<1000;i++) {
						arr[sc.nextInt()]++;
					}
					int max = 0;
					int max_ptr = 0;
					for(int i =0;i<=100;i++) {
						if(max <= arr[i]) {
							max = arr[i];
							max_ptr = i;
						}
						//System.out.println(arr[i]);
					}

					System.out.println("#"+testcase+" "+max_ptr);
				}
	}
}
