package Temp2021_1;

import java.io.*;
import java.util.*;

public class bac_DFS와BFS_S2 {

    static int N;
    static int M;
    static int V;

    static int[][] arr;
    static boolean[] visited;

    static Queue<Point> qu;

    static BufferedWriter bw;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        StringTokenizer st;
        qu = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }


        test();

        dfs(V);
        System.out.println(sb.toString());

        // 초ㅓ기화
        visited = new boolean[N+1];
        qu = new LinkedList<>();
        sb = new StringBuilder();

        bfs();

        //System.out.println();
        //pprint();

    }

    public static void test(){


        PriorityQueue<Point2>  qu2 = new PriorityQueue<Point2>();

        qu2.offer(new Point2(1,2,2));
        qu2.offer(new Point2(1,3,1));
        qu2.offer(new Point2(1,7,1));
        qu2.offer(new Point2(2,5,5));
        qu2.offer(new Point2(1,2,4));
        qu2.offer(new Point2(1,5,3));
        qu2.offer(new Point2(5,6,2));
        qu2.offer(new Point2(9,1,1));
        qu2.offer(new Point2(8,2,3));
        qu2.offer(new Point2(8,2,5));
        qu2.offer(new Point2(8,2,7));

        System.out.println();
        for(Point2 p2 : qu2){
            System.out.println(p2.toString());
        }
        System.out.println();

    }

    public static void dfs(int curX){
        qu.add(new Point(curX));
        visited[curX] = true;
        sb.append(curX +" ");

        for(int i=1; i<=N; i++){
            if(i==curX) continue;
            if(arr[curX][i] == 1 && !visited[i])
                dfs(i);
        }
    }

    public static void bfs() throws IOException {
        qu.add(new Point(V));
        visited[V] = true;

        while(!qu.isEmpty()){
            int dx = qu.poll().x;
            sb.append(dx + " ");
            //System.out.println("dx = " + dx);

            for(int j=1; j<=N; j++){
                if(dx == j) continue;

                //길이 있고, 방문 할수 있으면
                if(arr[dx][j] == 1 && !visited[j]){
                    qu.add(new Point(j));
                    visited[j] =true;
                }
            }
        }

        System.out.println(sb.toString());
    }
    public static void pprint(){
        for(int i=1; i<=N; i++){

            for(int j=1; j<=N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static class Point {
        int x;

        public Point(int x) {
            this.x = x;
        }

    }


    public static class Point2 implements Comparable<Point2> {
        int x;
        int y;
        int z;

        public Point2(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Point2{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        @Override
        public int compareTo(Point2 o1) {
            if(this.x != o1.x)
                return this.x - o1.y;
            else if(this.y != o1.y )
                return o1.y - this.y;
            else
                return o1.z - this.z;
        }
    }
}
