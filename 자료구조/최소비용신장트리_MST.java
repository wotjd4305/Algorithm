package 자료구조;

/*
그래프 상에서 최소 비용으로 모든 정점을 방문하는 방법.
      ※ 비용이 가장 적은 순서대로 선택 → 선택된 간선이 Cycle을 형성하면 제외.*/

import Algo.src.Z31_쿠르스칼_교수님;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


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

public class 최소비용신장트리_MST {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int p[];
    //static int rank[];

    public static void main(String args[]) throws IOException {

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

        //
        Arrays.sort(G);
        p = new int[V];
        for (int i = 0; i < p.length; i++) {
            makeSet(i);
        }
        int cnt = 0;
        int MST = 0;

        //
        for(int i=0; i<E; i++){
            Edge e = G[i];
            int px = findSet(e.src);
            int py = findSet(e.dsc);
            if(px != py){
                union(px, py);
                System.out.println(e.toString());//선택된 애
                cnt++;
                MST += e.val;
                if(cnt == V-1) break;
            }

        }

        System.out.println("크루스칼로 구한 MST 전체 가중치합 : " + MST);

    }

    public static void union(int x, int y){
        p[x] = y;
    }

    public static void makeSet(int i){
        p[i]= i;
    }

    public static int findSet(int x){
        if(p[x] == x){
            return x;
        }else{
            return p[x] = findSet(p[x]);
        }


    }


    public static class Edge implements Comparable<Edge> {
        int src;
        int dsc;
        int val;

        Edge(int src, int dsc, int val){
            this.src = src;
            this.dsc = dsc;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dsc=" + dsc +
                    ", val=" + val +
                    '}';
        }


        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }
}
