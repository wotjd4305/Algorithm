package main.java.Temp;

import java.util.Scanner;

public class bac11727_타일채우기2_S3_dp {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int memo[] = new int[N+1];

        if(N == 1) System.out.println("1");
        if(N == 2) System.out.println("3");
        if(N <=2 ) return;

        memo[1] = 1;
        memo[2] = 3;

        for (int i = 3; i <= N; i++) {
            memo[i] = memo[i-1]*2;
            memo[i] = ((i%2==0) ? memo[i]+1 : memo[i]-1) % 10007;
        }
            System.out.println(memo[N]);
    }
}
