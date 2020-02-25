package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe5986 {
      static Scanner sc = new Scanner(System.in); 
      static String[] StrArr = new String[5];
      static boolean[] arrPrime;
      static ArrayList<Integer> AL;
    public static void main(String[] args) {

    	int answer = 0;
        int T = sc.nextInt();

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {
        	
        	//N = 7~999
        	int input = sc.nextInt();
        	answer = solution(input);

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }
    
    //false is Prime
    public static void make_prime(int N)
    {
    	arrPrime = new boolean[N+1];
    	AL = new ArrayList<>();
    	
    	
    	Arrays.fill(arrPrime, false);
    	
    	for(int i=2; i<=N; i++)
    	{
    		//if arrPrime is false
    		if(!arrPrime[i])
    		{
    			AL.add(i);
    			for(int j=(2*i); j<=N; j+=i)
    			{
    				arrPrime[j] = true;
    			}
    		}
    	}	   	
    }
    
    public static int find_cases(int input)
    {
    	int result = 0;
    	
    	//AL = 2,3,5,7,11....
    	for(int i=0; i<AL.size(); i++)
    	{
    		for(int j=i; j<AL.size(); j++)
    		{
    			for(int k=j; k<AL.size(); k++)
    			{
    				int sum = AL.get(i) + AL.get(j) + AL.get(k);
    				if(sum == input)
    				{
    					result++;
    				}
    				
    			}
    			
    		}
    		
    	}
    	
    	return result;
    }

    public static int solution(int input)
    {
    	int result = 0;
    	make_prime(input);
    	result = find_cases(input);  		
    	return result;
    	     
    }
 


}