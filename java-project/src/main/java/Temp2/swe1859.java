package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class swe1859 {
      static Scanner sc = new Scanner(System.in);
      static int[] Arr;


    public static void main(String[] args) {

    	long answer = 0L;
        int T = sc.nextInt();

        for(int t=0; t<T; t++) {
        	
        	
        	int Num = sc.nextInt();
        	Arr = new int[Num];
        	
        	for(int i=0; i<Num; i++)
        	{
        		Arr[i]= sc.nextInt();
        	}
        	
        	
        	answer = solution(Num);
            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static long solution(int Num)
	{
		long result = 0L;
		int max = 0;
		for(int i =Num-1; i>=0; i--)
		{
			max = Math.max(Arr[i], max);

			result += max - Arr[i];
		}

		return result;

	}
 


}