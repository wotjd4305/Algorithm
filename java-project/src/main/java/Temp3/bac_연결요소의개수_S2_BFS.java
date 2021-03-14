package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class bac_연결요소의개수_S2_BFS {

    static int N;
    static int M;

    static int array[][];
    static boolean visited[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            array[x][y] = 1;
            array[y][x] = 1;
        }

        System.out.println(solution());

    }

    public static int solution(){

        int count = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        return count;
    }

    private static void dfs(int i) {
        if(visited[i]){
            return;
        }
        else{
            visited[i] = true;
            for(int j=1; j<=N; j++){
                if(array[i][j] == 1) {
                    dfs(j);
                }
            }

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
