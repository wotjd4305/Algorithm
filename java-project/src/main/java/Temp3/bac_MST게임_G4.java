package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac_MST게임_G4 {

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

        //시작점
        if( init != 1) {
            int n_x = Qu.peek().x;
            int n_y = Qu.peek().y;
            Qu.poll();
            array[n_x][n_y] = 0;
            array[n_y][n_x] = 0;
        }

        int start = Qu.peek().x;
        for(int i = 1; i<array[start].length; i++) {
            if(array[start][i]>0){
                value[i]= array[start][i];
            }else {
                value[i] = Integer.MAX_VALUE;
            }
        }

        selected[start] = true;
        value[start] = 0;


        for(int i=1; i<N; i++) {//정점이 계쏙 추가될것, 간선의 개수 N-1
            //한사이클마다 정점 1개 선택
            // 선택하지 않은 정점 중에서 가중치가 최소인 정점을 찾는다.
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int j = 1; j<=N; j++) {
                if(!selected[j] && min > value[j]) {
                    min = value[j];
                    idx = j;
                }
            }
            if(idx == -1){
                isAble = false;
                break;
            }
            selected[idx] = true;

            // 새로 선택한 정점을 통해서 개척된 새로운 경로를 업데이트(부모, 가중치)
            for(int j=1; j<=N; j++) {
                //선택하지 않은 정점 중, 인접했고, 가중치가 더 작으면 업데이트
                if(!selected[j] && array[idx][j] > 0 && value[j] > array[idx][j]) {
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
