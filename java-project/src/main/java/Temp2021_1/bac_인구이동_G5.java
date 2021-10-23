package main.java.Temp2021_1;

import java.io.*;
import java.util.*;

public class bac_인구이동_G5 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int L;
    static int R;

    static int arr[][];
    static int arr_temp[][];
    static boolean visited[][];

    // 북 동 남 서
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};

    static Queue<Ground> g_qu = new LinkedList<>();

    public static void main(String args[]) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        arr_temp = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        pprint();
    }

    public static void solution(){
        boolean isUpdated = true;
        int time =-1;
        while(isUpdated){
            isUpdated = setLink();
            time++;

            //arr 변경
            while(!g_qu.isEmpty()) {
                Ground g = g_qu.poll();
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if(arr_temp[i][j] == g.num)
                            arr[i][j] = g.v;
                    }
                }
            }

            //arr_temp 초기화
            init();
        }

        System.out.println(time);
    }

    public static boolean setLink() {

        boolean result = false;
        int gNum =0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                // 배열이 같으면


                if (visited[i][j]) continue;
                gNum++;


                Queue<Point> qu = new LinkedList<>();
                Queue<Point> qu2 = new LinkedList<>();

                qu.add(new Point(i, j, arr[i][j]));
                qu2.add(new Point(i, j, arr[i][j]));

                visited[i][j] = true;

                int sum = 0;
                while (!qu.isEmpty()) {
                    int c_x = qu.peek().x;
                    int c_y = qu.peek().y;
                    int c_v = qu.poll().v;

                    sum += c_v;

                    for (int d = 0; d < 4; d++) {
                        int n_x = c_x + dx[d];
                        int n_y = c_y + dy[d];

                        if (isRange(n_x, n_y) && !visited[n_x][n_y] && Math.abs(c_v - arr[n_x][n_y]) >= L && Math.abs(c_v - arr[n_x][n_y]) <= R) {
                            qu.add(new Point(n_x, n_y, arr[n_x][n_y]));
                            qu2.add(new Point(n_x, n_y, arr[n_x][n_y]));
                            visited[n_x][n_y] = true;
                        }
                    }
                }

                //초기화
                for (int t_i = 1; t_i <= N; t_i++) {
                    for (int t_j = 1; t_j <= N; t_j++) {
                        visited[t_i][t_j] = false;
                    }
                }

                //수정
                int c_sum = sum/qu2.size();
                g_qu.add(new Ground(gNum, c_sum));
                while(!qu2.isEmpty()){
                    if(qu2.peek().v != c_sum)
                        result = true;
                    arr_temp[qu2.peek().x][qu2.poll().y] = gNum;
                }
            }
        }

        return result;
    }


    public static void pprint(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void init(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr_temp[i][j] = 0;
            }
        }
    }

    public static boolean isRange(int x, int y){
        boolean result = false;
        if(x>=1&&y>=1 && x<=N && y<=N)
            result =true;
        return result;
    }

    public static class Point{
        int x;
        int y;
        int v;

        public Point(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

    }

    public static class Ground{
        int num;
        int v;

        public Ground(int num, int v) {
            this.num = num;
            this.v = v;
        }
    }
}
