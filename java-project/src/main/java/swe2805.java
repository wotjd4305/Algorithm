package main.java;

import java.util.Scanner;

public class swe2805 {
    static Scanner sc  = new Scanner(System.in);
    static int answer=0;
    static  int N;

    public static void main(String[] args) {


        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
        for(int T=1; T<=t; T++) {
            answer = 0;
            N = sc.nextInt();
            int Arr[][] = new int[N+1][N+1];

            for(int i=1; i<=N; i++)
            {
                String buffer = sc.next();
                for(int j=1; j<=N; j++)
                {
                    Arr[i][j] = Integer.parseInt(buffer.charAt(j-1) + "");
                }

            }
            answer = solution(N, Arr);
            System.out.println("#" + T + " " + answer);
        }
    }

    public static int solution(int N, int Arr[][])
    {
        int total = 0;
        //N = 7, -3~3
        for(int i= 1; i<=(N/2)+1; i++)
        {
            for(int j= (N/2)+2 -i; j< (N/2)+1 +i; j++)
            {
                total += Arr[i][j];
            }
        }

        //7~5
        //6일떄 3~5
        //5일때 2~6
        //i = 1~3 .. 7 6 5
        //4~4
        //3~5
        //2~6
        for(int i= 1; i<=(N/2); i++)
        {
            for(int j= (N/2)+2 -i; j< (N/2)+1 +i; j++)
            {
                total += Arr[N-i+1][j];
            }
        }

        return total;
    }

}
