package TextBook.DP;

import java.util.Scanner;

public class 막대놀이2_DP {
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int memo[] = new int[N+1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i=4; i<=N; i++){
            memo[i] = memo[i-1] + memo[i-2] * 2 + memo[i-3] * 4;
        }

        System.out.println(memo[8]);
    }

}
