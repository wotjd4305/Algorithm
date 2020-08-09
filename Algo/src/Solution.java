package Algo.src;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int result = 0;
            for(int i =0; i<10; i++)
            {
                int buffer = sc.nextInt();
                if(buffer%2 == 1)
                    result += buffer;
			}
            System.out.println("#" + test_case + " " + result);
	}
}
}