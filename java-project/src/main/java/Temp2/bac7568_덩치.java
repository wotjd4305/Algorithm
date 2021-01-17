package main.java.Temp2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class bac7568_덩치 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    static int[][] arr;
    static int[] rank;

    public static void main(String[] args) {

        int N = sc.nextInt();
        arr = new int[N][2];

        solution(N);
        for(int i : rank)
        System.out.print(i + " ");

    }

    public static void solution(int N)
    {
        //입력
        for(int i =0; i<N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //초기화
        rank = new int[arr.length];
        Arrays.fill(rank, arr.length);

        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j)
                    continue;

                if(arr[i][0]< arr[j][0] && arr[i][1] < arr[j][1])
                    continue;
                else
                    rank[i]--;

            }
        }
    }
}