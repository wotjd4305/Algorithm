package exam.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




public class soltuion6 {


    //상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static String arr[][];
    static Queue<Point> qu = new LinkedList<>();

    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input[] = br.readLine().split(";");
        int answer = 0;

        //배열만들고
        row = input.length;
        col = input[0].split(" ").length;
        arr = new String[row][col];

        //배열에 값넣고
        for(int i=0; i<input.length; i++){
            arr[i] = input[i].split(" ");
        }

        //출력 및 1찾기
        for(int i=0; i<row; i++){
            for(int j =0; j<col; j++){
                if(arr[i][j].equals("1")){
                    qu.add(new Point(i,j));
                }
            }
        }

        //돌리기
        while(!qu.isEmpty()){
            Point temp_p = qu.poll();
            int x= temp_p.x;
            int y= temp_p.y;

            for(int i=0; i<4; i++){
                int n_x = x + dx[i];
                int n_y = y+ dy[i];

                //범위안벗어나면
                if(isRange(n_x,n_y)){
                    if(arr[n_x][n_y].equals("0")) answer++;
                }
            }

        }

        System.out.println(answer);



    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static boolean isRange(int x, int y){
        boolean answer = true;
            if(x <0 && y<0 && x>=row && y>=col){
                answer = false;
            }
            return answer;
    }
}
