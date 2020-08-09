package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

class Solution4
{
	static Scanner sc = new Scanner(System.in);
	static int Num;
	static int[] arr_N;
	static int[] arr_C;
	static int answer=0;
	
	static int N;
	static int L;
	
	
	public static void main(String args[]) throws Exception
	{
		int T = sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			answer = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			
			arr_N = new int[N];
			arr_C = new int[N];
			solution(N,L);
			
			
			  System.out.println("#" + test_case + " " + answer);
	}
}
	
	
	public static void solution(int N, int L)
	{
		for(int i=0; i<N;i++)
		{
			//������ Į�θ�
			arr_N[i] = sc.nextInt();
			arr_C[i] = sc.nextInt();
			
		}
		
		
		for(int i=0; i<N;i++)
			dfs(i, arr_N[i], arr_C[i]);
		
	}
	
	public static void dfs(int idx, int score, int total)
	{
		if(total <= L)
			answer = Math.max(answer, score);
		else
			return;
		
		for(int i=idx+1; i<N; i++)
		{
			dfs(i, score+arr_N[i], total+arr_C[i]);
		}
		
	}
	
	
	
	

}