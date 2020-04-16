package main.java.Temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_SWEA_6719_D4 {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static int N;
    static int K;
    static ArrayList<Integer> AL;
    static double answer = 0;

    public static void main(String args[]){
        T = sc.nextInt();

        for(int i =0; i<T; i++){
            answer = 0;
            AL = new ArrayList<>();
            N =sc.nextInt();
            K =sc.nextInt();
            solution();
            System.out.println("#"+ (i+1)+ " " + answer);
        }
    }

    public static void solution(){
        //입력
        for(int i =0; i<N; i++) AL.add(sc.nextInt());
        AL.sort(Collections.reverseOrder());

        //9 5 5 3 2, idx - 0 1 2 3 4
        //0.625 + 1.25 + 4.5
        // 5/8 + 5/4 + 9/2
        for(int i = K-1; i>=0; i--){
            answer += AL.get(i)/Math.pow(2,(i+1));
        }




    }
}
