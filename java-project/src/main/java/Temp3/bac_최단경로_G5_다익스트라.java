package main.java.Temp3;

import TextBook.최단경로.Dijkstra_PQ;

import java.io.*;
import java.util.*;

public class bac_최단경로_G5_다익스트라 {

    static int V;
    static int E;
    static int K;

    static List<Point>[] al;
    static boolean visited[];
    static int D[];

    static final int INF = 9898798;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        al = new ArrayList[V+1];

        for(int i = 1; i <= V; i++)
            al[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            al[x].add(new Point(y, val));
        }

        solution();



    }

    public static void solution() throws IOException {


        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V+1];
        Point[] D = new Point[V+1];


        //0번에서 출발하는걸로.
        for(int i = 1; i <= V; i++) {
            //원하는 출발지
            if( i == K ) {
                D[i] = new Point(i, 0);
            }
            else {
                D[i] = new Point(i, INF);
            }
            pq.add(D[i]);
        }

        while( !pq.isEmpty() ) {
            Point edge = pq.poll();

            for( Point next : al[edge.v] ) {
                // check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
                if( !check[next.v] && D[next.v].w > D[edge.v].w + next.w ) {
                    D[next.v].w = D[edge.v].w + next.w;
                    //decrease key
                    pq.remove(D[next.v]);
                    pq.add(D[next.v]);
                }
            }
            check[edge.v] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(D[i].w != INF) sb.append(D[i].w+"\n");
            else sb.append("INF\n");
        }
        //System.out.println(sb.toString());
        bw.write(sb.toString());
        bw.close();
        br.close();
    }



    public static class Point implements Comparable<Point>{
        int v;
        int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return this.v - o.v;
        }
    }
}
