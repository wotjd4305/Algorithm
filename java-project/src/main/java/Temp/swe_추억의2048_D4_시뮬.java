package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_추억의2048_D4_시뮬 {

    static int N;

    static int Arr[][];

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    //상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N입력과 초기화
        int T = Integer.parseInt(st.nextToken());

        for(int test =0; test<T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Arr = new int[N][N];
            int dir = 0;
            String temp_s = st.nextToken();

            if (temp_s.equals("up")) dir = 0;
            else if (temp_s.equals("down")) dir = 1;
            else if (temp_s.equals("left")) dir = 2;
            else dir = 3;


            //입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution( dir);
            System.out.println("#"+(test+1));
            print();

        }
    }

    public static void solution(int dir) {
        //합치고, 움직여라.
        move(dir);
        merge(dir);
        move(dir);
    }

    private static void merge(int dir) {
        switch (dir) {
            case UP:
                for(int i=0; i<N-1; i++){
                    for(int j=0; j<N; j++){
                        if(Arr[i][j] == 0) continue;
                        if(Arr[i][j] == Arr[i+1][j]){
                            Arr[i][j] *= 2;
                            Arr[i+1][j] = 0;
                        }
                    }
                }
                break;
            case DOWN:
                for(int i=N-1; i>0; i--){
                    for(int j=N-1; j>=0; j--){
                        if(Arr[i][j] == 0) continue;
                        if(Arr[i][j] == Arr[i-1][j]){
                            Arr[i][j] *=2;
                            Arr[i-1][j] = 0;
                        }
                    }
                }
                break;
            case LEFT:
                for(int j=0; j<N-1; j++){
                    for(int i=0; i<N; i++){
                        if(Arr[i][j] == 0) continue;
                        if(Arr[i][j] == Arr[i][j+1]){
                            Arr[i][j] *=2;
                            Arr[i][j+1] =0;
                        }
                    }
                }
                break;
            case RIGHT:
                for(int j=N-1; j>0; j--){
                    for(int i=N-1; i>=0; i--){
                        if(Arr[i][j] == 0) continue;
                        if(Arr[i][j] == Arr[i][j-1]){
                            Arr[i][j] *=2;
                            Arr[i][j-1] = 0;
                        }
                    }
                }
                break;
        }
    }


    public static void move(int dir){
        switch (dir) {
            case UP:
                for(int n=0; n<N-1;n++) {
                    for (int i = 1; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if (Arr[i][j] == 0) continue;
                            if (Arr[i - 1][j] == 0) {
                                Arr[i - 1][j] = Arr[i][j];
                                Arr[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case DOWN:
                for(int n=0; n<N-1;n++) {
                    for (int i = N - 2; i >= 0; i--) {
                        for (int j = N - 1; j >= 0; j--) {
                            if (Arr[i][j] == 0) continue;
                            if (Arr[i + 1][j] == 0) {
                                Arr[i + 1][j] = Arr[i][j];
                                Arr[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case LEFT:
                for(int n=0; n<N-1;n++) {
                    for (int j = 1; j < N; j++) {
                        for (int i = 0; i < N; i++) {
                            if (Arr[i][j] == 0) continue;
                            if (Arr[i][j - 1] == 0) {
                                Arr[i][j - 1] = Arr[i][j];
                                Arr[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case RIGHT:
                for(int n=0; n<N-1;n++) {
                    for (int j = N - 2; j >= 0; j--) {
                        for (int i = N - 1; i >= 0; i--) {
                            if (Arr[i][j] == 0) continue;
                            if (Arr[i][j + 1] == 0) {
                                Arr[i][j + 1] = Arr[i][j];
                                Arr[i][j] = 0;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void print(){
        for(int[] row : Arr) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
