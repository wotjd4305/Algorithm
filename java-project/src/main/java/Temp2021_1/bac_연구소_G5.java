package main.java.Temp2021_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_연구소_G5 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int arr[][];

    //북 동 서 남
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static int stone[];
    static int combArr[];

    static int answer =0;

    static Queue<Point> qu = new LinkedList<>();
    static Queue<Point> qu_copy = new LinkedList<>();
    static Queue<Point> visited_qu = new LinkedList<>();

    public static void main(String args[]) throws IOException {

        qu.clear();

        answer = 0;

        stone = new int[3];

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        combArr = new int[N*N];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++) {
                if(arr[i][j] == 2)
                    qu_copy.add(new Point(i,j));
            }
        }

        //pprint();

        qu.addAll(qu_copy);
        solution();

    }

    public static void solution() {
        visited_qu.clear();
        dfs(0);
        System.out.println(answer);
   }

    public static void bfs(){
        while(!qu.isEmpty()){
            Point p = qu.poll();
            for(int i=0; i<4; i++) {
                int n_x = p.x + dx[i];
                int n_y = p.y + dy[i];
                if (isRanged(n_x, n_y) && !isBlocked(n_x, n_y)) {
                    qu.add(new Point(n_x, n_y));
                    visited_qu.add(new Point(n_x, n_y));
                    arr[n_x][n_y] = 2;
                }
            }
        }
    }

    public static void dfs(int count){
        if(count == 3){
            bfs();
            qu.clear();
            answer = Math.max(answer, safeZone());

            //System.out.println(safeZone());
            //pprint();
            //다시 채우기
            qu.addAll(qu_copy);

            //초기화
            while(!visited_qu.isEmpty()) {
                Point vp = visited_qu.poll();
                arr[vp.x][vp.y] = 0;
            }

            return;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++) {
                if(!isBlocked(i,j)) {
                    arr[i][j] = 1;
                    dfs(count + 1);
                    arr[i][j] = 0;
                }
            }
        }

    }



    public static boolean isRanged(int x, int y){
       boolean result = false;
       if( x>=1 && y>=1 && x<=N && y<=M){
           result = true;
       }
       return result;
    }

    public static boolean isBlocked(int x, int y){
        boolean result = false;
        if( arr[x][y] == 1 || arr[x][y] == 2){
            result = true;
        }
        return result;
    }

    public static void pprint(){

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static int safeZone(){
        int result = 0;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(arr[i][j] == 0) result++;
            }
        }
        return result;
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
