package main.java;

import java.util.Scanner;

public class swe2817 {
    static Scanner sc  = new Scanner(System.in);
    static int Arr[];
    static int K;
    static int N;
    static int answer=0;

    public static void main(String[] args) {


        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
        for(int T=1; T<=t; T++) {
            N = sc.nextInt();
            K = sc.nextInt();
            Arr = new int[N+1];
            answer = 0;

            //입력
            for(int i=1; i<=N; i++)
            {
                Arr[i] = sc.nextInt();
            }

            //시작
            for(int i=1; i<=N; i++)
                solution(i,0);


            System.out.println("#" + T + " " + answer);
        }
    }

    public static void solution(int start, int count)
    {
        count += Arr[start];
        //종료 시점
        if(count == K)
            answer++;

        for(int j=start+1; j<=N; j++)
            solution(j, count);


    }


}
