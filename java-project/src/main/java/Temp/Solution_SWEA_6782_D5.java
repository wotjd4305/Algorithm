package main.java.Temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_SWEA_6782_D5 {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static long N;

    static long answer = 0;

    public static void main(String args[]){
        T = sc.nextInt();

        for(int i =0; i<T; i++){
            answer = 0;
            N =sc.nextInt();
            solution();
            System.out.println("#"+ (i+1)+ " " + answer);
        }
    }

    public static void solution(){
        long temp = 0;
        long interval = 0;

        while(N!=2){
            if(N == 1){ N++; answer++; continue;}
            temp = (long)Math.sqrt(N);
            if(N == temp*temp) {
                N = temp;
                answer++;
                continue;
            }
            interval = (long)Math.pow(temp+1, 2) - N;
            answer += interval;
            N = (long) Math.pow(temp+1,2);
        }
    }




}
