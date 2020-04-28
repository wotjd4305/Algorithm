package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac12100_2048_G2_dfs {

    static int N;
    static int answer;
    static int Arr[][];
    static int Arr_clone[][];

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
        N = Integer.parseInt(st.nextToken());
        answer = 0;
        Arr = new int[N][N];

        //입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                   Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i<4; i++){
            copy( Arr,Arr_clone);
            dfs(0, i);
            copy(Arr_clone, Arr);
        }

        System.out.println(answer);
    }

    // 자바 5000천만
    // N 1~20
    // 4*4*4*4*4  1024*3*20*20
    public static void dfs(int cnt, int dir) {

        //종료 조건.
        if(cnt == 5){
            int cur_answer = findMax();
            answer = Math.max(answer, cur_answer);
            return;
        }

        //합치고, 움직여라.
        move(dir);
        merge(dir);
        move(dir);

        for(int i =0; i<4; i
                ++){
            copy(Arr, Arr_clone);
            dfs(cnt+1, i);
            copy(Arr_clone, Arr);
        }
    }

    private static int findMax() {
        int result =0;
        for(int i=0; i<N; i++){
            for(int j =0; j<N; j++){
                result = Math.max(result, Arr[i][j]);
            }
        }
        return result;
    }

    //위면 i =0, j=0부터 i,j
    //아래면 i=N, j=N부터 i,j
    //왼쪽 i=0, j=0 부터 j,i
    //오른쪽 i=N-1, j=N-1부터 j,i
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
    public static void copy(int [][] src,int[][] dsc){
        int idx_i =0;
        int idx_j =0;
        for(int[] row : src) {
            idx_i=0;
            for(int col : row) {
                dsc[idx_i++][idx_j] = col;
            }
            idx_j++;
        }
    }

    public static void print(){
        for(int[] row : Arr) {
            for(int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
