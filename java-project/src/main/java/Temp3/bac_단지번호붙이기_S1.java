package main.java.Temp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac_단지번호붙이기_S1 {

    public static int N;
    public static int map[][];
    public static boolean visited[][];

    //동서남북
    public static int dx[] = {0,0,1,-1};
    public static int dy[] = {1,-1,0,0};

    static int count;
    static Integer Acount[];

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        Acount = new Integer[N*N];

        for(int i=0; i<N*N; i++){
                Acount[i] = 0;

        }






        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }

        solution();

        //pprint();
        System.out.println(count);
        Arrays.sort(Acount, Collections.reverseOrder());
        for(int i=N*N-1; i>=0; i--){
            if(Acount[i] == 0) continue;
            System.out.println(Acount[i]);
        }
    }

    public static void solution(){

        Queue<Point> qu = new LinkedList<>();
        count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1 ){
                    qu = new LinkedList<>();
                    qu.add(new Point(i,j));
                    visited[i][j] = true;
                    count++;
                    map[i][j] = count;

                    while(!qu.isEmpty()){

                        Acount[count-1]++;

                        int curX = qu.peek().x;
                        int curY = qu.poll().y;

                        for(int k =0; k<4; k++) {
                         int nX = curX + dx[k];
                         int nY = curY + dy[k];
                         if (isRanged(nX,nY) && map[nX][nY] == 1 && !visited[nX][nY]){
                             qu.add(new Point(nX, nY));
                             map[nX][nY] = count;
                             visited[nX][nY] = true;
                         }
                        }

                    }
                }
            }
        }
    }

    public static void pprint(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRanged(int x, int y){
        boolean result = false;
        if(x<N && y<N && x>=0 && y >= 0){
            result = true;
        }
        return result;
    }

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
}
