package main.java.Temp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac_수들의합2_실_투포인터 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;

    static int answer = 0;

    static Integer arr[];

    public static void main(String args[]) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new Integer[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    public static void solution(){
        int p1 = 0 , p2 = 0;

        //N보다 하나 작게
        while(p2 <= N){

            int sum = 0;
            for(int i=p1; i<p2; i++){
                sum += arr[i];
            }

            if(sum < M) p2++;
            else if(sum >= M) {
                if(sum == M) answer++;

                //같으면
                if(p1 == p2) {
                    p2++;
                }else{
                    p1++;
                }
            }
        }
        System.out.println(answer);
    }
}