package main.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_0504_Algo2_서울_11반_박재성 {

    static int T;
    static int R;
    static int C;
    static int N;

    static String map[][];
    static int instrution[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken()); // 가로
            C = Integer.parseInt(st.nextToken()); // 세로
            map = new String[R][C]; // 지도

            //맵 채우기
            for(int i =0; i<R; i++){
                    map[i] = br.readLine().split("");
            }

            //초기화
            N = Integer.parseInt(br.readLine());
            instrution = new int[N]; // 명령기억공간

            //명령입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                instrution[i] = Integer.parseInt(st.nextToken());

            solution();
            pprint(); // 정답 출력
        }
    }

    private static void solution() {
        for(int i =0; i<N; i++)
            move(instrution[i]);
    }

    //맵을 출력하는 메소드
    public static void pprint() {
        for(String[] row : map){
            for(String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public static void move(int loc_i){
            int row = 0;
            int loc = loc_i-1;
             while(true){
                 if(isRange(row,loc) && isRange(row+1,loc) && map[row+1][loc].equals("X")){
                     map[row][loc] = "O";
                     break;
                 }
                 else if(isRange(row, loc) && row == R-1){
                     map[row][loc] = "O";
                     break;
                 }//밑에 막혀있있고
                 else if(isRange(row,loc) &&isRange(row+1,loc) && map[row+1][loc].equals("O")) {
                     //왼쪽
                     if (isRange(row, loc - 1) && isRange(row + 1, loc - 1) && map[row + 1][loc - 1].equals(".") && map[row][loc - 1].equals(".")) {
                         row++;
                         loc--;
                     }//오른쪽
                     else if (isRange(row, loc + 1) && isRange(row + 1, loc + 1) && map[row + 1][loc + 1].equals(".") && map[row][loc + 1].equals(".")) {
                         row++;
                         loc++;
                     }//왼쪽오른쪽 막혀있고 밑에 O면 그대로 쌓임
                     else{
                         map[row][loc] = "O";
                         break;
                     }
                 }
                 else{
                     row++;
                 }

        }
    }


    public static boolean isRange(int row, int col){
        boolean result = false;
        if(row >=0 && col>=0 && row<R && col <C)
            result = true;
        return result;
    }
}