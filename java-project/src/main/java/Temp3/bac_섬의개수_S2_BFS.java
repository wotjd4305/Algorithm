package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_섬의개수_S2_BFS {

    static int W,H;
    static int array[][];
    static boolean visited[][];

    //
    static int dx[] = {0,0,1,-1, 1,-1,-1,1};
    static int dy[] = {1,-1,0,0, 1,-1,1,-1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {

            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W==0 && H ==0) return;

            array = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //pprint();

            System.out.println(Solution());
        }
    }

    public static int Solution(){

        int count =0;

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(array[i][j] == 1 && !visited[i][j]){
                    Queue<Point> qu = new LinkedList<>();
                    qu.add(new Point(i,j));
                    visited[i][j] = true;
                    count++;
                    while(!qu.isEmpty()){
                        int c_x = qu.peek().x;
                        int c_y = qu.poll().y;
                        for(int k=0; k<8; k++){
                            int n_x = c_x + dx[k];
                            int n_y = c_y + dy[k];
                            if(isRange(n_x,n_y) && !visited[n_x][n_y] && array[n_x][n_y] == 1){
                                qu.add(new Point(n_x, n_y));
                                visited[n_x][n_y] = true;
                            }
                        }
                    }
                }
            }
        }

        return count;

    }

    public static void pprint(){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(array[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isRange(int x , int y){
        boolean result = false;

        if(x>=0 && y>=0 && x<H && y<W){
            result = true;
        }

        return result;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
