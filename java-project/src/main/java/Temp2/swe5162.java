package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe5162 {
      static Boolean P_Arr[];
      static ArrayList<Integer> AL = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer;

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {

        	int A = sc.nextInt();
        	int B = sc.nextInt();
        	int C = sc.nextInt();
        	
            answer = Solution(A,B,C);
            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static int Solution(int A, int B, int C)
    {
        int answer = 0;
        int count = C;
        int max = Math.max(A, B);
        int min = Math.min(A,B);
        
        answer += C/min;
        
        return answer;
    }


}