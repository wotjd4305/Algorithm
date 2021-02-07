package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_미로탐색_S1_그래프 {

    static int N;
    static int M;

    //북 동 남 서
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    //
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(t.charAt(j) + "");
            }
        }

        solution();

        System.out.println(map[N-1][M-1]);

    }

    public static void solution(){
        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point(0,0,1));

        while(!qu.isEmpty()){
            Point t = qu.poll();

            for(int i=0; i<4; i++){


                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                int value = t.value + 1;
                Point point = new Point(nx,ny,value);
                if(isRange(nx,ny) && map[nx][ny] >= 1 && ( (value < map[nx][ny]) || map[nx][ny] == 1  ) ){
                    qu.add(point);
                    map[nx][ny] = value;
                }
            }
        }


    }

    public static boolean isRange(int x, int y){
        boolean result = true;
        if(x >= N || y >= M || x <0 || y<0){
            result = false;
        }
        return result;
    }


    public static class Point{
        int x;
        int y;
        int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
