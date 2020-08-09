package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swe_탈주범검거_모의 {

    static int N;
    static int M;
    static int R;
    static int C;
    static int L;

    static int answer;
    static int time;
    static Point Stone = new Point(-1,-1);


    //1 - 상하좌우, 2 - 상하, 3 - 좌우
    //4 - 상우, 5- 하,우 6- 하좌, 7 - 상좌a
    static int[][] st_arr = {{0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0},
};

    static Queue<Point> Q = new LinkedList<>();

    static int arr[][];
    static boolean visit[][];

    //상 하 좌 우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N입력과 초기화
        int T = Integer.parseInt(st.nextToken());


        for(int test =0; test<T; test++) {
            answer = 0;
            time = 0;
            Q.clear();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visit = new boolean[N][M];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

           // pprint();

            Solution();
            System.out.println("#"+ (test+1) + " " +answer);
        }
    }

    private static void Solution() {
        Q.add(new Point(R,C));
        Q.add(Stone);
        visit[R][C] = true;
        answer++;
        time++;



        while(!Q.isEmpty()){

            //시간추가
            if(Q.peek() == Stone){
                time++;
                Q.poll();
                Q.add(Stone);
                //돌만남았다면.
                if(Q.size() == 1) break;
            }


            int c_x = Q.peek().x;
            int c_y = Q.poll().y;
            //시간이되면 끝.
            if(time == L)
                break;


            for(int i =0; i<4; i++){
                int st = arr[c_x][c_y];

                //배수로 방향으로 갈수 없으면 못감
                if(st_arr[st][i] == 0) continue;


                //상대편 배수로 방향도 있어야함
                int other_i = (i%2 == 0) ? i+1 : i-1;

                int n_x = c_x + dx[i];
                int n_y = c_y + dy[i];

                //범위니?
                if(isRange(n_x,n_y) && !visit[n_x][n_y] && st_arr[arr[n_x][n_y]][other_i] !=0 ) {
                    visit[n_x][n_y] = true;
                    answer++;

                    Q.add(new Point(n_x, n_y));
                }
            }
        }

    }

    public static void pprint(){
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int x, int y){
        boolean result = false;
        if(x<N && y<M && x>=0 && y>=0){
            result = true;
        }
        return result;
    }


    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return (x +","+ y).hashCode();
        }
    }
}
