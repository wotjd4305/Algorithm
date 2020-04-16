package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SWEA_하나로_Prim {
    static int N;
    static double arr[][];
    static int x[]; static int y[];
    static int p[];
    static double answer;
    static double E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int idx;
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new double[N][N];
            x = new int[N]; y = new int[N];

            //배열 입력.
            idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) x[idx++] = Integer.parseInt(st.nextToken());

            idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) y[idx++] = Integer.parseInt(st.nextToken());

            //세율입력
            E = Double.parseDouble(br.readLine());

            //거리 계산하여 넣기
            cal();
            solution();

            sb.append("#" + (test) +" "+ String.format("%.0f", answer)+"\n");
        }
        System.out.println(sb);
    }
    public static void cal(){
        for(int i =0; i<N; i++){
            for(int j=i+1; j<N; j++){
                arr[i][j] = E * Math.abs(Math.pow((x[i] - x[j]),2) + Math.pow((y[i] - y[j]),2));
                arr[j][i] = arr[i][j];
            }
        }
    }

    public static void solution(){
        double MST = 0;
        boolean check[] = new boolean[N]; //
        int p[] = new int[N];
        double key[] = new double[N];

        Arrays.fill(key, Double.MAX_VALUE);
        p[0] = -1;
        key[0] = 0;

        for(int i =0; i<N-1; i++){
            double min = Double.MAX_VALUE;
            int idx = -1;
            for(int j =0; j<N; j++) {
                if (!check[j] && key[j] < min) {
                    idx = j;
                    min = key[j];
                }
            }

            check[idx] = true;
            for(int j=0; j<N; j++){
                if(!check[j] && arr[idx][j] != 0 && key[j] > arr[idx][j]){
                    p[j] = idx;
                    key[j] = arr[idx][j];
                }
            }
        }

        for(double d : key) MST += d;
        answer = MST;
    }
}