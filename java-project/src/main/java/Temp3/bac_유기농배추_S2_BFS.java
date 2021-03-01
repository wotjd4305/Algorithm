package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bac_유기농배추_S2_BFS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static int M,N,K;

    static int array[][];

    //동 서 남 북
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};

    public static void main(String args[]) throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            array = new int[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                array[x][y] = 1;
            }

            System.out.println(solution());

        }

    }

    private static int solution() {

        int count = 0;

        for(int i =0; i<M; i++){
            for(int j=0; j<N; j++){
                Queue<Point> qu = new LinkedList<>();
                if(array[i][j] == 1){
                    count++;
                    qu.add(new Point(i,j));
                    array[i][j] = 2;

                    while(!qu.isEmpty()){
                        int c_x = qu.peek().x;
                        int c_y = qu.poll().y;

                        for(int k=0; k<4; k++){
                            int n_x = c_x + dx[k];
                            int n_y = c_y + dy[k];
                            if(isRange(n_x,n_y) && array[n_x][n_y] == 1){
                                qu.add(new Point(n_x,n_y));
                                array[n_x][n_y] = 2;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //N M x y
    public static boolean isRange(int x, int y){
        boolean result = false;
        if(x>=0 && x<M && y>=0 && y<N){
            result = true;
        }
        return result;
    }
}
