package main.java.Temp;

import java.util.Scanner;

public class Solution_SWEA_조합_D4 {

    static final int MOD = 1234567891;
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int R;
    static long answer = 0;
    static long FA[];


    public static void main(String[] args) {

        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {

            answer = 0;
            N = sc.nextInt();
            R = sc.nextInt();

            FA = new long[N + 1];

            //1부터시작.
            FA[0] = 1;
            for (int i = 1; i <= N; i++)
                FA[i] = (FA[i - 1] * i) % MOD;

            long pre_val = (FA[R]*FA[N-R]) % MOD;
            long post_val = Ferma(pre_val, MOD - 2);

            answer = (FA[N] * post_val) % MOD;

            System.out.println("#" + (test) +" "+ answer);
        }
    }

    //분할정복
    public static long Ferma(long cur_val, int m_cnt) {

        if (m_cnt == 0)
            return 1;

        long temp = Ferma(cur_val, m_cnt / 2);
        long result = (temp * temp) % MOD;

        //딱 절반으로 나뉘면
        if (m_cnt % 2 == 0)
            return result;
        //ex)143/2 -> 71
        return (result * cur_val) % MOD;
    }
}