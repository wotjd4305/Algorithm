package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bac2146_다리만들기_G3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R;
    static int C;
    static int answer = Integer.MAX_VALUE;

    static int map[][];
    static boolean visited[][];
    static Point Dummy = new Point(-1,-1,-1);

    //상 하 좌 우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    //큐
    static Queue<Point> Qu = new LinkedList<>();
    static ArrayList<Point> Al = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = R;
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i =0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬에 번호주기
        giveNumber();
        pprint();

        boolean flag;
        for( Point p : Al){
                int i = p.x;
                int j = p.y;

                flag = false;
                //1) 여기가 강이면 불가능
                if(map[i][j] == 0) continue;

                //2) 주변에 강이 있어야 다리를 놓을 수 있음.
                for(int k =0; k<4; k++){
                    int n_x = i + dx[k];
                    int n_y = j + dy[k];
                    //갈수 있고, 강일경우
                    if(isRange(n_x,n_y) && map[n_x][n_y] == 0){
                        flag = true;
                    }
                }
                if(!flag) continue; // 강이없으면 다음.

                bfs(i,j,map[i][j]);
        }

        System.out.println(answer);

    }

    public static void giveNumber(){
        int cnt=2;

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    Qu.clear();
                    Qu.add(new Point(i,j));
                    Al.add(new Point(i,j));
                    map[i][j] = cnt;
                    visited[i][j] = true;

                    while(!Qu.isEmpty()){
                        int c_x = Qu.peek().x;
                        int c_y = Qu.poll().y;

                        for(int k=0; k<4; k++){
                            int n_x = c_x + dx[k];
                            int n_y = c_y + dy[k];
                            if(isRange(n_x,n_y) && !visited[n_x][n_y] && map[n_x][n_y] ==1){
                                Qu.add(new Point(n_x,n_y));
                                Al.add(new Point(n_x,n_y));
                                map[n_x][n_y] = cnt;
                                visited[n_x][n_y] = true;
                            }
                        }
                    }//while
                    cnt++;
                }//if
            }//for j
        }//for i
    }

    private static void bfs(int x, int y, int num) {
        Qu = new LinkedList<>();
        Qu.add(new Point(x,y,0));
        visited = new boolean[R][C];
        visited[x][y] = true;

        while(!Qu.isEmpty()){
            int c_x = Qu.peek().x;
            int c_y = Qu.peek().y;
            int c_w = Qu.poll().val;

            if(answer < c_w) break;

            for(int i=0; i<4; i++){
                int n_x = c_x + dx[i];
                int n_y = c_y + dy[i];

                //범위 안이고, 방문안했고
                if(isRange(n_x,n_y) && !visited[n_x][n_y]){
                    if(map[n_x][n_y] == 0) { //강이면
                        Qu.add(new Point(n_x, n_y, c_w + 1));
                        visited[n_x][n_y] = true;
                    }
                    else if(map[n_x][n_y] != num){ //육지이며 다른 육지면
                        //System.out.println("거리 = " + (c_w));
                        answer = Math.min(answer, (c_w));
                    }
                }
            }

        }



    }


    public static boolean isRange(int x, int y){
        boolean result = false;
        if(x>=0 && y>=0 && x<R && y<C){
            result = true;
        }
        return result;
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
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void pprint(){
        for(int i =0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}