package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bac11404_플로이드_G4_dp {

    static int N;
    static int M;
    static long dis[][];

    static final long m = 100000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dis = new long[N+1][N+1];

        for(long row[] : dis) Arrays.fill(row, m);
        for(int i =0; i<=N; i++) dis[i][i] = 0;


        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(dis[a][b] != 0) dis[a][b]= Math.min(c,dis[a][b]);
            else dis[a][b] = c;
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(k==i) continue;
                for(int j=1; j<=N; j++){
                    if(j == i || k == j) continue;
                    if(dis[i][k] != m && dis[k][j] != m)
                        dis[i][j] = Math.min(dis[i][k] + dis[k][j], dis[i][j]);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++){
                if(dis[i][j] >= m) System.out.print(0 + " ");
                else System.out.print((dis[i][j]) +" ");
            }
            System.out.println();
        }
    }
}
