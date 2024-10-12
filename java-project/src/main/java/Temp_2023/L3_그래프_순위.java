package Temp_2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L3_그래프_순위 {

    public static void main(String[] args) {
        int n = 5;
        int[][] vertex = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n, vertex));
    }

    public static long solution(int n, int[][] results) {

        int answer = 0;

        boolean win[][] = new boolean[n+1][n+1];
        boolean lose[][] = new boolean[n+1][n+1];


        // 채우기
        for (int[] ints : results) {
            win[ints[0]][ints[1]] = true;
            lose[ints[1]][ints[0]] = true;
        }


        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(win[i][k] && win[k][j]) {
                        win[i][j] = true;
                        lose[j][i] = true;
                    }

                    if(lose[i][k] && lose[k][j]) {
                        lose[i][j] = true;
                        win[j][i] = true;
                    }
                }
            }
        }

        for(int i=1;i<n+1;i++){
            int tmpNumber = 0;
            for(int j=1;j<n+1;j++){
                if((lose[i][j] == true) || (win[i][j] == true)) tmpNumber++;
            }
            if(tmpNumber == n-1) answer++;
        }


        return answer;
    }
}
