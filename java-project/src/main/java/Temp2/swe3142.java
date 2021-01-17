package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class swe3142 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    static int Arr[];

    public static void main(String[] args)
    {
        solution();
    }

    public static void solution()
    {
        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
            for(int T=1; T<=t; T++) {
                 int N = sc.nextInt();
                 int M = sc.nextInt();

                 int unihorn_num;
                 int twinhorn_num;

                 for(int i =0; i<=M; i++)
                 {
                     unihorn_num = (M-i)*1;
                     twinhorn_num = i*2;
                     int total_num = unihorn_num + twinhorn_num;

                     if(N == total_num)
                         System.out.println("#" + T + " " + (M-i) + " " + i);

                 }

        }

    }

}

