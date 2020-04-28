package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bac14499_주사위굴리기_G5_시뮬 {

    static int N;
    static int M;
    static int K;

    static int[][] Map;
    static int[] K_ins;

    static int[] Dice = {0,0,0,0,0,0,0};

    //동 서 북 남
    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};

    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        //N입력과 초기화
        int x = 0;
        int y = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
        }


        //맵 초기화와 셋팅팅
        Map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //명령 셋팅
        K_ins = new int[K];
        st = new StringTokenizer(br.readLine());
        int idx=0;
        while(st.hasMoreTokens()) {
            K_ins[idx++] = Integer.parseInt(st.nextToken());
        }

        solution(x,y);
        System.out.println(sb);
    }

    // 1 2 3 4 | 동 서 북 남
    private static void solution(int x, int y) {
        //시작은 언제나 1

        for(int i =0; i<K; i++){
            int n_x = x +dx[K_ins[i]];
            int n_y = y +dy[K_ins[i]];

            if(isRange(n_x,n_y)) {

                change(K_ins[i]);
               if(Map[n_x][n_y] == 0){
                   Map[n_x][n_y] = Dice[6];
               }else{
                   Dice[6] = Map[n_x][n_y];
                   Map[n_x][n_y] = 0;
            }

                sb.append( Dice[1] + "\n");
                x = n_x;
                y = n_y;

            }
        }
    }

    public static void change(int dir) {
        int top = Dice[1];
        //동 서 북 남
        switch (dir) {
            case 1:
                Dice[1] = Dice[4];
                Dice[4] = Dice[6];
                Dice[6] = Dice[3];
                Dice[3] = top;
                break;
            case 2:
            Dice[1] = Dice[3];
            Dice[3] = Dice[6];
            Dice[6] = Dice[4];
                Dice[4] = top;
                break;
            case 3:
            Dice[1] = Dice[5];
            Dice[5] = Dice[6];
            Dice[6] = Dice[2];
                Dice[2] = top;
                break;
            case 4:
            Dice[1] = Dice[2];
            Dice[2] = Dice[6];
            Dice[6] = Dice[5];
                Dice[5] = top;
                break;
        }
    }

    public static boolean isRange(int x, int y){
        boolean result = false;
        if(x>=0&&y>=0&&x<N&&y<M)
            result = true;
        return result;
    }
}
