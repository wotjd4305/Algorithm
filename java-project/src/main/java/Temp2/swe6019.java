package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe6019 {
      static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {

    	double answer = 0;
        int T = sc.nextInt();

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {
        	
        	int D = sc.nextInt();
        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	int F = sc.nextInt();      	
        	
        	answer = solution(D,A,B,F);

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    //250 10 15 20
    //A(10)---250----B(-15)
    
    public static double solution(int D, int A, int B, int F)
    {
    	double result = 0.0;
  
    	double sum = A + B; 	
    	double second = D/sum;
    	result = F * second; 	
    	return result;
    	     
    }

}