package main.java.Temp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

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
        //LinkedHashSet<Integer> hs = new LinkedHashSet<>();

        while(flag){
            flag = false;
            //hs.clear();

            //1 ~ N 까지의 큐
            for(int i=1; i<=N; i++) {
                if(degree[i] == 1){
                    flag = true;
                    for(Integer q : qu[i]){
                        degree[q]--;
                    }
                    sb.append(i+" ");
                    degree[i] =0;
                }
            }

        }

        System.out.println(sb.toString());
    }
}
