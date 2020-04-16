package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac1932_정수삼각형_S1_dp {

    static int N;
    static int figure[][];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        figure = new int[N][N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int col_idx = 0;
            while(st.hasMoreTokens()){
                figure[i][col_idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = N-2; i>=0; i--)
            for(int j= i; j>=0; j--)
                figure[i][j] = figure[i][j] + Math.max(figure[i+1][j], figure[i+1][j+1]);

        System.out.println(figure[0][0]);

    }
}
