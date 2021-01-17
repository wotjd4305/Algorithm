package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe5215 {
      static Boolean P_Arr[];
      static ArrayList<Integer> AL = new ArrayList<>();
      static int N ;
  	  static int L ;
  	  static int scores[];
      static int cols[];
      static int answer=0;
      static Scanner sc = new Scanner(System.in); 

    public static void main(String[] args) {

        int T = sc.nextInt();

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {

        	//�ʱ�ȭ
        	answer =0;
        	N = sc.nextInt();
        	L = sc.nextInt();
        	scores = new int[N];
        	cols = new int[N];
        	
        	
        	solution(N,L);

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static void solution(int N, int L)
    {
       for(int i =0; i<N; i++)
       {
    	   scores[i] = sc.nextInt();
    	   cols[i] = sc.nextInt();
       }
       
       dfs(0,0,0);
    }
    
    public static void dfs(int idx, int score, int col)
    {
    	if(col > L)
    		return;
    	if(idx == N)
    	{
    		//System.out.println(score + "  -  " + col);
    		answer = Math.max(score, answer);
    		return;
    	}
    	
    	
    	int n_score = scores[idx];
    	int n_col = cols[idx];
    	
    	dfs(idx+1, score, col);
    	dfs(idx+1, score+n_score, col+n_col);
    	
    }


}