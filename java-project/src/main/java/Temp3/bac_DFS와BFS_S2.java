package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_DFS와BFS_S2 {

    static int N;
    static int M;
    static int V;

    static boolean visisted[];
    static int map[][];
    static boolean flag = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        //4 5 1
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visisted = new boolean[N+1];
        map = new int[N+1][N+1];

        //입력
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y]= 1;
            map[y][x]= 1;
        }

        //pprint();

        solution();
    }

    public static void solution(){


        DFS(V);
        //초기화
        visisted = new boolean[N+1];
        System.out.println();
        BFS();
    }

    public static void BFS(){
        Queue<Integer> qu = new LinkedList<>();



        //첫번째 Point 제작
//        Point first = null;
//        for(int i=1; i<=M; i++){
//            if(map[V][i] == 1){
//                first = new Point(V,i,0);
//                break;
//            }
//        }

        Integer first = V;
        qu.add(first);
        visisted[V] = true;

        while(!qu.isEmpty()){
            int curX = qu.poll();
            System.out.print(curX + " ");
            for(int i=1; i<=N; i++){
                if(map[curX][i] == 1 && !visisted[i]){
                    //System.out.println(curX);
                    visisted[i] = true;
                    qu.add(i);
                }
            }
        }
        //System.out.println("나왔다");


    }

    public static void DFS(int i) {
        visisted[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= N; j++) {
            if(map[i][j] == 1 && visisted[j] == false) {
                DFS(j);
            }
        }
    }

    public static void pprint(){
        System.out.println("-----------");
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static class Point{
        int x;
        int y;
        int value;

        public Point(int x,int y,int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static boolean isRanged(int x, int y){
        boolean result = true;
        if(x>N || y>N || x<1 || y<1){
            result = false;
        }
        return result;
    }
}
