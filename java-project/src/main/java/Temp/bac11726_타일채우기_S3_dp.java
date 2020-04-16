package main.java.Temp;

import java.util.Scanner;

public class bac11726_타일채우기_S3_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int memo[] = new int[N+1];
        memo[1] = 1;
        if(N >=2) memo[2] = 2;

        if(N == 1) System.out.println(memo[1]);
        else if(N == 2) System.out.println(memo[2]);
        else {
            for (int i = 3; i <= N; i++) {
                memo[i] = (memo[i - 1] + memo[i - 2]) %10007;
            }
            System.out.println(memo[N]);
        }
    }
}
