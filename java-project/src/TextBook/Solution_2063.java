package TextBook;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//int TC = sc.nextInt();//num of Testcases
		int TC = 1;
		for (int testcase = 1; testcase <= TC; testcase++) {
			int num = 0;
			num = sc.nextInt();
			int arr[] = new int[num];
            int sum = 0;
            for(int i =0;i<num;i++){
            	arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            System.out.println(arr[num/2]);
						
		}

		
	}

}
