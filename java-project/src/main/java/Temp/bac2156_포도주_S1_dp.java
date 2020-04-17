package main.java.Temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bac2156_포도주_S1_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        int score[] = new int[N+1];

        for(int i =1; i<=N; i++)
            score[i] = sc.nextInt();

        dp[0] = 0;
        dp[1] = score[1];
        if(N>=2) dp[2] = score[2] + dp[1];

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3]+ score[i-1] + score[i]);
            dp[i] = Math.max(dp[i-1] , dp[i]);
        }

        System.out.println(dp[N]);


    }
}
