package main.java.Temp2021_1.단순반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_줄세우기_G2_위상정렬 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static Queue<Integer>[] qu;

    static int degree[];

    static int N;
    static int M;

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        qu = new LinkedList[N+1];
        for(int i=1; i<=N; i++){
            qu[i] = new LinkedList<>();
        }



        degree = new int[N+1];

        Arrays.fill(degree,1);
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dsc = Integer.parseInt(st.nextToken());
            qu[src].add(dsc);
            degree[dsc]++;
        }
        solution();
    }

    public static void solution(){

        boolean flag = true;

        while(flag){
            flag = false;

            for(int i=1; i<=N; i++){
                if(degree[i] == 1){
                    flag = true;
                    for(Integer value : qu[i]){
                        degree[value]--;
                    }
                    degree[i] = 0;
                    sb.append(i + " ");
                }
            }


        }


        System.out.println(sb.toString());
    }
}
