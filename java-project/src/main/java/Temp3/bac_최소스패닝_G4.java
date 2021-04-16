package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac_최소스패닝_G4 {

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
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            AL.add(new Point(x,y,val));
        }

//        for(Point p : qu){
//            System.out.println(p.toString());
//        }

        solution();

    }

    public static void solution(){

        p = new int[V+1];

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Point)o1).val - ((Point) o2).val;
            }
        };

        Collections.sort(AL,comparator);

//                for(Point p : AL){
//            System.out.println(p.toString());
//        }


        //makeset
        for(int i =1; i<=V; i++) p[i] = i;

        int cnt = 0;
        answer = 0;

        for(int i=0; i<AL.size(); i++){
            int dx = findSet(AL.get(i).x);
            int dy = findSet(AL.get(i).y);
            if(dx != dy){
                union(dx,dy);
                cnt++;
                answer += AL.get(i).val;

                if(cnt == V-1)
                    break;
            }


        }

        System.out.println(answer);

    }

    public static int findSet(int num){
        if(p[num] == num)
            return num;
        else
            return p[num] = findSet(p[num]);
    }

    public static void union(int dx, int dy){
        p[dy] = dx;
    }

    public static class Point{
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
    }
}
