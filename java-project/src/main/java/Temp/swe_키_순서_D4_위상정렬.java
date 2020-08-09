package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swe_키_순서_D4_위상정렬 {

    static int N;
    static int M;
    static int answer = 0;
    static int MAX = Integer.MAX_VALUE;

    static int arr[][];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N입력과 초기화
        int T = Integer.parseInt(st.nextToken());

        for(int test =0; test<T; test++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            arr = new int[N+1][N+1];
            for(int row[] : arr){
                Arrays.fill(row,MAX);
            }

            for(int i =0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());
                arr[big][small] = 1;
            }

            for(int k=1; k<=N; k++){
                for(int i=1; i<=N; i++){
                    for(int j=1; j<=N; j++){
                        if(arr[i][k] != MAX && arr[k][j] != MAX)
                            if(arr[i][j] > arr[i][k] + arr[k][j])
                                arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }

            for(int i=1; i<=N; i++){
                boolean isClear = true;
                for(int j=1; j<=N; j++){
                    if(i==j) continue;
                    if(arr[i][j] == MAX) { //하위를 뺸것 중에 무한대가있고
                        if(arr[j][i] == MAX){  // 그 뺀것의 상위가 명확하지 않으면
                            isClear = false;
                            break;
                        }
                    }
                }
                if(isClear){
                    answer++;
                }
            }
            System.out.println("#"+ (test+1) + " " +answer);
        }
    }
}
