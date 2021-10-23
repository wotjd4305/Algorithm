package main.java.Temp2021_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_뱀_G5 {





    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N;
    static int K;
    static int L;

    static int arr[][];

    // 북 동 서 남
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};

    static Queue<DIR> qu = new LinkedList<>();
    static Queue<Point> p = new LinkedList<>();

    public static void main(String args[]) throws IOException {

        qu.clear();
        p.clear();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            int x =  Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        for(int i=1; i<=L; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int d = 0;
            System.out.println("##" + dir);
            switch (dir){
                case "D":
                    d=1;
                    break;
                case "L":
                    d=-1;
                    break;
            }
            qu.add(new DIR(time,d));
        }

        pprint();

        for(DIR i : qu){
            System.out.println(i);
        }

        solution();

    }

    public static void solution(){
        p.add(new Point(1,1));

        //첫 방향 오른쪽
        int dir = 1;
        int answer= -1;

        int n_x = 1;
        int n_y = 1;

        while(true){
            answer++;

            System.out.println("도는 중 - " + answer);

            //시간이 맞으면 방향바꿔
            if(!qu.isEmpty()) {
                if (qu.peek().time == answer) {

                    dir = dir + qu.peek().dir;
                    if(dir == -1) dir = 3;
                    if(dir == 4) dir = 0;
                    qu.poll();
                    System.out.println("현재시간 : " + answer);
                }
            }

            int cur_x = n_x;
            int cur_y = n_y;
            n_x = cur_x + dx[dir];
            n_y = cur_y + dy[dir];

            System.out.println("새 위치" + n_x +", " + n_y);

            //범위 안이고
            if(isRanged(n_x,n_y)){

                boolean ate = false;

                //해당이 사과인가
                if(arr[n_x][n_y] == 1){
                    arr[n_x][n_y] = 0;
                    ate = true;
                }

                //해당 범위가 꼬리인가
                if(p.contains(new Point(n_x,n_y))){
                    break;
                }
                else{
                    Point curP = new Point(n_x,n_y);
                    System.out.println("뱀 머리 위치 : " + curP);
                    p.add(curP);
                }

                //사과 먹었으면
                if(ate){

                }
                //안먹었으면 꼬리잘라
                else{
                  p.poll();
                }

            }
            else
                break;

        }

        System.out.println("#답이다 : " + answer);
    }

    public static void pprint(){
        for(int i=1; i<=N; i++){

            for(int j=1; j<=N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static class DIR{
        @Override
        public String toString() {
            return "DIR{" +
                    "time=" + time +
                    ", dir=" + dir +
                    '}';
        }

        int time;
        int dir;

        public DIR(int time, int dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    public static class Point{
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static boolean isRanged(int x, int y){
       boolean result = false;
       if(x >=1 && y>=1 && x<=N && y<=N){
           result = true;
       }
       return result;
    }

}
