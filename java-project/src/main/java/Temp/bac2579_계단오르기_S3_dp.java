package main.java.Temp;

import java.util.Scanner;

public class bac2579_계단오르기_S3_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[N+1];
        int score[] = new int[N+1];

        for(int i =1; i<=N; i++)
            score[i] = sc.nextInt();

        dp[1] = score[1];
        if(N>=2)
            dp[2] = dp[1] + score[2];

        //N부터 하향식으로 생각해서 도출

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3]+ score[i-1] + score[i]);
        }
            System.out.println(dp[N]);
    }
}
