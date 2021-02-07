package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_바이러스_S3_그래프 {

    static int N;
    static int M;
    static boolean map[][];
    static boolean visited[];

    static int count =0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            map[y][x] = true;

        }

        solution();
        System.out.println(count);

    }

    public static void solution(){
        visited[1] = true;

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);

        while (!qu.isEmpty()) {
            int temp = qu.poll();

            for(int i=1; i<=N; i++){
                if(map[temp][i] && temp != i  && !visited[i]){
                    qu.add(i);

                    //System.out.println("## " + i);

                    visited[i] = true;
                    count++;
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
