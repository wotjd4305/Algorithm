package main.java.Temp2021_1.단순반복;

import java.awt.desktop.UserSessionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_MST게임_G4_prim {

    static int N,M,K;
    static int value[];
    static boolean selected[];
    static int array[][];

    static Queue<Point> Qu = new LinkedList<>();

    static long answers[];
    static boolean isAble = true;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N+1][N+1];
        value = new int[N+1];
        selected = new boolean[N+1];

        //간선 채우기
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            array[a][b] = i;
            array[b][a] = i;
            Qu.add(new Point(a,b));
        }


        answers = new long[K+1];
        for(int i=1; i<=K; i++) {
            solution(i);
            if(!isAble)
                break;
        }

        for(int i=1; i<=K ; i++){
            System.out.print(answers[i] + " ");
        }

}

    public static void solution(int init){

        //
        value = new int[N+1];
        selected = new boolean[N+1];

        if(init != 1){
          int cx =  Qu.peek().x;
          int cy =  Qu.peek().y;
          Qu.poll();
          array[cx][cy] = 0;
          array[cy][cx] = 0;
        }

        int start = Qu.peek().x;
        Arrays.fill(array, Integer.MAX_VALUE);
        for(int i=1; i<=N; i++){
            if(array[start][i] > 0){
                value[i] = array[start][i];
            }
        }
        selected[start] = true;
        value[start] = 0;

        for(int i=1; i<=N; i++){

            int idx =-1;
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=N; j++){
                if(!selected[j] && value[j] < min) {
                    min = value[j];
                    idx = j;
                }
            }

            if(idx==-1){
                isAble = false;
                break;
            }

            selected[idx] = true;

            for(int j=1; j<=N; j++){
                if(!selected[j] && array[idx][j] > 0 && value[j] < array[idx][j]) {
                   value[j] = array[idx][j];
                }
            }


        }




        if(isAble) {
            //최소거리
            long answer = 0;
            for (int i = 1; i <= N; i++)
                answer += value[i];
            answers[init] = answer;
        }

    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
