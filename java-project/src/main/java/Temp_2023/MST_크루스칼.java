package Temp_2023;

import TextBook.그래프탐색.Z31_쿠르스칼_교수님;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
입력값
7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51
*/
public class MST_크루스칼 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int p[];
    static int rank[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 간선의 배열 사용
        Edge[] G = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            G[i] = new Edge(a, b, val);
        }

        Arrays.sort(G);

        p = new int[V];
        rank = new int[p.length];

        //SET만들기
        for(int i=0; i<p.length; i++) {
            p[i] = i;
        }

        int cnt = 0;
        int MST = 0;

        for(int i =0; i<E; i++) {
            Edge e = G[i];
            int px = findSet(e.a);
            int py = findSet(e.b);
            if (px != py) {
                union(px, py);
                cnt++;
                MST += e.val;
                if (cnt == V - 1) {
                    break;
                }
            }
        }
        System.out.println("크루스칼로 구한 MST 전체 가중치합 : " + MST);

    }

    // x를 포함하는 집합의 대표자
    private static int findSet(int x) {
        if (p[x] == x)
            return x;
        else {
            return p[x] = findSet(p[x]); //PathComprresion;
        }
    }

    public static void union(int px, int py){
        if(rank[px] > rank[py]){
            p[py] = px;
        } else {
            p[px] = py;
            if(rank[px] == rank[py]){
                rank[py]++;
            }
        }

    }

    public static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int val;

        public Edge(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Edge e) {
            return this.val - e.val;
        }
    }
}
