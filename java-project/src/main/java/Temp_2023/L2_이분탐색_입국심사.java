package Temp_2023;

import java.util.Arrays;

public class L2_이분탐색_입국심사 {

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        int num = 0;

        long left;
        long right;
        long max = 0;
        long mid = 0;

        long total =0;

        //가장 길게 걸리는 심사대
        max = Arrays.stream(times).max().getAsInt();

        left =1;
        right = (long)n*max;

        while(left <= right)
        {
            total = 0;
            mid= (left+right)/2;

            for(int time : times)
            {
                total += (mid/time);
            }

            //생각보다 숫자가 크다 mid를 줄이자
            if(total >= n)
            {
                right = mid -1;
            }
            //생각보다 숫자가 작다. mid를 늘리자
            else
            {
                left = mid +1;
            }
        }

        return left;
    }
}
