package main.java;

import java.util.Scanner;

public class swe3282 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    static int N;//물건갯수
    static int K;//한도
    static int[][] Arr;
    static boolean visit[];

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        int t = sc.nextInt();
        for (int T = 1; T <= t; T++) {
            answer = 0;
            N = sc.nextInt();
            K = sc.nextInt();
            visit = new boolean[N];
            Arr = new int[N][2];

            //입력
            //0 부피, 1 가치
            for (int i = 0; i < N; i++) {
                Arr[i][0] = sc.nextInt();
                Arr[i][1] = sc.nextInt();
            }

            //처리
            //N은 물건갯수, K는 한도
            for (int i = 0; i < N; i++) {
                visit[i] = true;
                dfs(Arr[i][0], Arr[i][1]);
                visit[i] = false;
            }
            System.out.println("#" + T + " " + answer);
        }
    }

    public static void dfs(int volum_total, int value_total) {
        //부피넘으면 빠져나가기
        if (volum_total > K)
            return;

        if(value_total > answer){
            answer = Math.max(answer, value_total);
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(volum_total + Arr[i][0], value_total + Arr[i][1]);
                visit[i] = false;
            }
        }
    }
}