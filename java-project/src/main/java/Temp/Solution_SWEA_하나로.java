package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_SWEA_하나로 {
    static int N;
   static ArrayList<Edge> AL = new ArrayList<>();

    static int x[]; static int y[];

    static int p[];

    static boolean arr_b[][];

    static double answer;
    static double E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int idx;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {

            answer = 0;
            AL.clear();
            N = Integer.parseInt(br.readLine());
            arr_b = new boolean[N][N];
            x = new int[N]; y = new int[N];

            //배열 입력.
            idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) x[idx++] = Integer.parseInt(st.nextToken());

            idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) y[idx++] = Integer.parseInt(st.nextToken());

            //세율입력
            E = Double.parseDouble(br.readLine());

            //거리 계산하여 넣기
            cal();
            solution();

            sb.append("#" + (test) +" "+ String.format("%.0f", answer)+"\n");
        }
        System.out.println(sb);
    }
    public static void cal(){
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j || arr_b[i][j]) continue;
                 AL.add(new Edge(i,j,E * Math.abs(Math.pow((x[i] - x[j]),2) + Math.pow((y[i] - y[j]),2))));
                 arr_b[i][j] = true; arr_b[j][i] = true;
            }
        }
    }

    public static void solution(){
        //정점수.
        p = new int[N];

        //집합으로
        for(int i =0; i<p.length; i++) p[i] = i;

        //거리 입력후, 정렬
        Collections.sort(AL);

        int cnt = 0; // 선택된 간선의 개수
        double MST = 0; // 최소 신장트리 가중치합

        // 가중치가 최소인 간선을 선택 V-1개
        for (int i = 0; i < AL.size(); i++) {
            Edge e = AL.get(i);
            int px = findSet(e.a);
            int py = findSet(e.b);
            if(px != py){
                union(px, py);
                cnt++;
                MST += e.val;
                if(cnt == N-1){
                    break;
                }
            }
        }
        answer = MST;
    }

    public static void union(int px, int py) {
        p[py] = px; //py의 대표자를 px로 한것!
    }

    // x를 포함하는 집합의 대표자
    private static int findSet(int x) {
        if(p[x] == x) return x;
        else return p[x] = findSet(p[x]);
    }

    public static class Edge implements Comparable<Edge> {
        int a; int b;
        double val;

        public Edge(int a, int b, double val) {
            super();
            this.a = a; this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.val - o.val > 0) return 1;
            else if(this.val - o.val == 0) return 0;
            return -1;
        }
    }
}