package main.java.Temp2021_1.단순반복;


import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

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


        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        boolean[] check = new boolean[V + 1];
        int[] D = new int[V + 1];
        Arrays.fill(D, INF);
        D[K] = 0;
        pq.add(new Point(K, 0));

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            if(check[cur.w]) continue;
            check[cur.w] = true;

            for(Point next : al[cur.w]){
                if(D[next.w] > D[cur.w] + next.v){
                    D[next.w] =  D[cur.w] + next.v;
                    pq.add(new Point(next.w, D[next.w]));
                }
            }
        }





            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= V; i++) {
                if (D[i] != INF) sb.append(D[i] + "\n");
                else sb.append("INF\n");
            }
            bw.write(sb.toString());
            bw.close();
            br.close();

    }

        public static class Point implements Comparable<Point> {
            int w;
            int v;

            public Point(int w, int v) {
                this.v = v;
                this.w = w;
            }

            @Override
            public int compareTo(Point o) {
                return this.v - o.v;
            }
        }


}