package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class swe6718 {
      static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    	int answer =0;
        int T = sc.nextInt();

        //testcase
        for(int t=0; t<T; t++) {
        	answer = 0;
        	long input = sc.nextLong();
        	answer = solution(input);
  
            System.out.println("#"+ (t+1) + " " + answer);
        }
    }
    
  
    public static int solution(long Num)
    {
    	int result = 0;
    	double value = 10;
    	
    	if(Num < Math.pow(value,2))
    		result = 0;
    	else if(Num < Math.pow(value,3))
    		result = 1;
    	else if(Num < Math.pow(value,4))
    		result = 2;
    	else if(Num < Math.pow(value,5))
    		result = 3;
    	else if(Num < Math.pow(value,6))
    		result = 4;
    	else 
    		result = 5;
    	
    	return result;
    }


}