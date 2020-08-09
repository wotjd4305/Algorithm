package Algo.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인구이동 {

    static int N;
    static int L;
    static int R;

    static int[][] m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        m = new int[N][N];

        for(int i =0; i<m.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j= 0; j<m.length; j++){
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
