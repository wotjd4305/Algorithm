package main.java.Temp2021_1.단순반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bac_최소스패닝_G4_크루스칼 {

    static int answer;
    static int V;
    static int E;
    static ArrayList<Point> AL = new ArrayList<>();

    static int p[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            AL.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        solution();
    }

    public static void solution(){

        p = new int[V+1];
        Collections.sort(AL);

        int cnt=0;
        int answer = 0;

        for(int i=1; i<=V; i++){
            p[i] =i ;
        }

        for(int i=0; i<AL.size(); i++) {

            int dx = findSet(AL.get(i).x);
            int dy = findSet(AL.get(i).y);
            if (dx != dy) {
                answer = AL.get(i).val;
                union(dx, dy);
                cnt++;
            }

            if (cnt == V - 1) break;

        }


        System.out.println(answer);

    }

    public static int findSet(int num){
        if(num == p[num]) return num;
        else
            return p[num] = findSet(p[num]);
    }

    public static void union(int dx, int dy){
        p[dx] = dy;
    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            return this.val - o.val;
        }
    }
}
