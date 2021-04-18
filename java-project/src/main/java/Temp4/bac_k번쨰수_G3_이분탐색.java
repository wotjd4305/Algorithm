package main.java.Temp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac_k번쨰수_G3_이분탐색 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int K;

    static long answer = 0;

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        solution();

        System.out.println(answer);

    }

    public static void solution() {
        answer = bSearch(1, K);
    }

    public static long bSearch(long left, long right) {

        if(left > right) return left;

        long cnt;
        long mid;

        cnt = 0;
        mid = (left + right) / 2;

        for (int i = 1; i <= N; i++) {
            cnt += Math.min(mid / i, N);
        }

        if (cnt >= K) {
            return bSearch(left, mid-1);
        } else{
            return bSearch(mid + 1, right);
        }
    }

}
