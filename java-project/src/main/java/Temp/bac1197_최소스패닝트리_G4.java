package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac1197_최소스패닝트리_G4 {
    static int answer;
     static int p[];
    static ArrayList<Edge> AL = new ArrayList<>();

    static int V;
    static int E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

            answer = 0;
            AL.clear();

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                V = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    AL.add(new Edge(x,y,Integer.parseInt(st.nextToken())));
                }
            }

            //거리 계산하여 넣기
            solution();

        System.out.println(answer);
    }


    public static void solution(){
        //정점수.
        p = new int[V+1];

        //집합으로
        for(int i =1; i<p.length; i++) p[i] = i;

        //익명클래스 써보기..
        Comparator<Edge> comp = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
               return o1.val - o2.val;
            }
        };

        //거리 입력후, 정렬
        Collections.sort(AL, comp);

        int cnt = 0; // 선택된 간선의 개수
        int MST = 0;

        // 가중치가 최소인 간선을 선택 V-1개
        for (int i = 0; i < AL.size(); i++) {
            Edge e = AL.get(i);
            int px = findSet(e.a);
            int py = findSet(e.b);
            if(px != py){
                union(px, py);
                cnt++;
                MST += e.val;
                if(cnt == V-1){
                    break;
                }
            }
        }
        answer = MST;
    }

    public static void union(int px, int py) {
        p[py] = px;
    }

    public static int findSet(int x) {
        if(p[x] == x) return x;
        else return p[x] = findSet(p[x]);
    }

    public static class Edge{
        int a; int b;
        int val;

        public Edge(int a, int b, int val) {
            this.a = a; this.b = b;
            this.val = val;
        }
    }
}