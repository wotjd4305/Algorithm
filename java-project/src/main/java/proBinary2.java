package main.java;

public class proBinary2 {
    public static void main(String[] args) {

        int times[] = {7, 10};
        int n = 6;
        System.out.println(solution(n, times));
    }

    // 1- 7,14,21,28
    // 2- 10, 20
    public static long solution(int n, int[] times) {
        long left;
        long right;
        long max = 0;
        long mid = 0;

        long total =0;

        //가장 길게 걸리는 심사대
        for(int time : times)
        {
            if(max < time)
                max = time;
        }

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