package Algo.src.WorkShop;
import java.util.Arrays;
import java.util.Scanner;

class SWEA_Solution_2063_중간값찾기_D1_박재성
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] arr;
		int T =1;
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            arr = new int[N];
                     
            
            for(int i =0; i<N; i++)
            {
               arr[i] = sc.nextInt();
			}
            Arrays.sort(arr); 
            System.out.println("#" + test_case + " " + arr[N/2]);
	}
}
}