package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_토마토_S1_BFS {

    //북 동 서 남 상 하
    static int dx[] = {-1,0,0,1,0,0};
    static int dy[] = {0,1,-1,0,0,0};
    static int dz[] = {0,0,0,0,-1,1};

    //
    static int arr[][][];
    static boolean visited[][][];

    //상자 크기 | 상자 수
    static int M; //가로
    static int N; //세로
    static int H;

    //
    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // y
        N = Integer.parseInt(st.nextToken()); // x
        H = Integer.parseInt(st.nextToken()); // z

        arr = new int[N][M][H];
        visited = new boolean[N][M][H];

        for(int i =0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //pprint();

        solution();

        System.out.println(isSucces() ? answer : -1);
    }

    public static void solution(){
        Queue<Point> qu = new LinkedList<>();
        fillQue(qu);
//
//        for(Point p : qu){
//            System.out.println(p);
//        }

        //시간용
        qu.add(new Point(-1,-1,-1));

        while(true){
            //System.out.println("hi");

            if(qu.peek().equals(new Point(-1,-1,-1))){
                //System.out.println("시간지남");
               qu.poll();
               qu.add(new Point(-1,-1,-1));
               if(qu.size() < 2){
                   break;
               }
                answer++;

            }

            Point temp = qu.poll();
            int cur_x = temp.x;
            int cur_y = temp.y;
            int cur_z = temp.z;

            for(int i=0; i<6; i++){
                int n_x = cur_x + dx[i];
                int n_y = cur_y + dy[i];
                int n_z = cur_z + dz[i];
                if(isRange(n_x,n_y,n_z) && !visited[n_x][n_y][n_z] && arr[n_x][n_y][n_z] == 0 ){
                    //System.out.println("추가");
                    visited[n_x][n_y][n_z] = true;
                    arr[n_x][n_y][n_z] = 1;
                    qu.add(new Point(n_x,n_y,n_z));
                }
            }
        }


    }

    public static boolean isRange(int x, int y, int z){
        boolean result = false;
        if(x>=0 && x<N && y>=0 && y<M && z>=0 && z<H){
            result = true;
        }
        return result;
    }

    public static void pprint(){
        for(int i =0; i<H; i++){
                for(int j=0; j<N; j++){
                for(int k=0; k<M; k++) {
                    System.out.print(arr[j][k][i] + " ");
                }
                    System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSucces(){
        boolean result = true;
        for(int i =0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++) {
                    if(arr[j][k][i] == 0){
                        result = false;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void fillQue(Queue<Point> qu){

        for(int i =0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++) {
                    if(arr[j][k][i] == 1){
                        qu.add(new Point(j,k,i));
                    }
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y &&
                    z == point.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
}
