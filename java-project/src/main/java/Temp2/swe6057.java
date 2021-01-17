package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe6057 {
      static Scanner sc = new Scanner(System.in);
      static boolean[][] map;
      static boolean[][] visited;
      
      static int answer= 0;
      static int N;
      
    public static void main(String[] args) {

    	
        int T = sc.nextInt();

        //testcase
        for(int t=0; t<T; t++) {
        	
        	//input
        	answer = 0;
        	N = sc.nextInt();
        	int M = sc.nextInt();
        	
        	//init
        	map = new boolean[N+1][N+1];
        	visited = new boolean[N+1][N+1];
        	
        	for(boolean[] row : map)
        		Arrays.fill(row , false);
        	for(boolean[] row : visited)
        		Arrays.fill(row , false);
        	
     	
        	answer = solution(N,M);

            System.out.println("#"+ (t+1) + " " + answer);
        }
    }
   
    //N = 5
    //1 2 -> 2 3 -> 3 1 (Trinagle)
    //5 2 -> 2 3 -> 3 5
    public static int solution(int N, int M)
    {
    	MakeGraph(M);
    	
    	for(int i =1; i<=N; i++) {
    		for(int j = i; j<=N; j++)
    		{
    			if(map[i][j] == true)
    				{
    					visited[i][j] = true;
    					visited[j][i] = true;
    				
    					System.out.println("i = " + i
        						+ "j = " + j);
    					dfs(i,j,i,j,1);
    					
    					
    					visited[i][j] = false;
    					visited[j][i] = false;
    				
    				}
    		}
    		
    	}	 	
    	return answer/6;	     
    }
    
    public static void dfs(int first_s, int first_d,
    		int src, int dsc, int count)
    {
    	if(count == 3)
    		{
    		if((first_s == src && first_d == dsc)||
    				(first_d == src || first_d == dsc))
    			{
    			System.out.println("END");
    			answer++;
    			}
    		return;
    		}
    	
    	for(int i =1; i<=N; i++)
    	{
    		if(i == dsc)
    			continue;
    		if(map[src][i] == true && !visited[src][i])
    			{
    				System.out.println("src = " + src
    						+ "i = " + i + "  count" + count);
    				visited[src][i] = true;
    				visited[i][src] = true;
    				
    				dfs(first_s, first_d,src,i,count+1);
    				dfs(first_s, first_d,i,src,count+1);
    				
    				
    				visited[src][i] = false;
    				visited[i][src] = false;
    				
    				
    			}
    		
    	}
    	
    }
    
    public static void MakeGraph(int M)
    {
    	for(int i =0; i<M; i++)
    	{
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		map[a][b] = true;
    		map[b][a] = true;
    	}   	
    }

}