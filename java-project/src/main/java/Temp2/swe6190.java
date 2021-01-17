package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swe6190 {
      static Scanner sc = new Scanner(System.in);
      static ArrayList<Integer> AL;
      static long answer= 0;
      static int Num =0;
      
    public static void main(String[] args) {

    	
        int T = sc.nextInt();

        //testcase
        for(int t=0; t<T; t++) {
        	answer = 0;
        	Num = sc.nextInt();
        	AL = new ArrayList<>();
        	
        	answer  = solution(Num);
        	
            System.out.println("#"+ (t+1) + " " + answer);
        }
    }
    
    
    //1<= i <= j <= N
    //N(1<=N<=1000)
    //Ai(1<=A<=30000) 
    public static long solution(int Num)
    {
    	boolean isDanjo = true; 
    	
    	//input
    	for(int i =0; i<Num; i++)    
    		AL.add(sc.nextInt());
    	
    	/*//In case - Array
    	isDanjo = Find_Danjo_Array();
    	if(isDanjo == false)
    		return -1;
    	*/
    	
    	//make a C, In case - Value
    	long result = MakeC(Num); 
    	return result;
    }
    
    public static long MakeC(int Num)
    {
    	long max = -1;
    	
    	for(int i =0; i < Num; i++)
    	{
    		for(int j =i+1; j<Num; j++)
    		{
    			long temp = AL.get(i)*AL.get(j);
    			
    			if(Find_Danjo_value(temp))
    				{
    					max = Math.max(max, temp);
    				}
    		}
    	}   	
    	return max;
    }
    
    
    
    //this Value is Danjo?
    public static boolean Find_Danjo_value(long input)
    {
    	boolean result = true;
    	String input_str = "" + input;
    	
    	for(int i =0; i<input_str.length()-1; i++)
    	{
    		if(input_str.charAt(i) > input_str.charAt(i+1))
    		{
    			result = false;
    			return result;
    		}
    	}	   	
    	return result;
    }
    
    //Compare with between A and sorted_A
    public static boolean Find_Danjo_Array()
    {
    	//AL for copy
    	boolean result = true;
    	ArrayList<Integer> AL_buf = new ArrayList<>();
    	AL_buf.addAll(AL);
    	
    	Collections.sort(AL);
    	for(int i =0; i<AL.size(); i++)
    		if(AL.get(i) != AL_buf.get(i))
    			result = false;
  	
    	return result;
    }

}