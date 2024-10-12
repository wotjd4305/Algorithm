package Temp_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
5 6
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
public class 한정점_다익스트라 {

    static int M = Integer.MAX_VALUE;
    static ArrayList<Vertex>[] G;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        G = new ArrayList[v + 1];
        int[] D = new int[v + 1];
        boolean[] visited = new boolean[v + 1];


        for (int i = 1; i <= v; i++) {
            G[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            G[start].add(new Vertex(dest, value));
        }

        int start = 1;
        D[start] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));

        while (!pq.isEmpty()) {
            Vertex now = pq.poll();

            if (!visited[now.index]) {
                visited[now.index] = true;
            }

            for (Vertex next : G[now.index]) {

                if (!visited[next.index] && D[next.index] > now.val + next.val) {
                    D[next.index] = now.val + next.val;
                    pq.add(new Vertex(next.index, D[next.index]));
                }
            }
        }

        //최소거리 출력
        for(int i : D) {
            if(i == M) System.out.print("INF ");
            else System.out.print(i+" ");
        }

    }

    public static class Vertex implements Comparable<Vertex>{
        int index;
        int val;

        public Vertex(int a, int val) {
            this.index = a;
            this.val = val;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.val - o.val;
        }
    }
}
