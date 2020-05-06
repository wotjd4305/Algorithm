package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac6987_월드컵_S3 {


   static int games[][];
   static int total =0;

   static int team1[] = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
   static int team2[] = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
   static boolean flag;

    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t =0; t<4; t++) {
            games = new int[6][3];
            total =0;
            flag = false;

            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {//승 무 패
                total += games[idx][0] = Integer.parseInt(st.nextToken());
                total += games[idx][1] = Integer.parseInt(st.nextToken());
                total += games[idx][2] = Integer.parseInt(st.nextToken());
                idx++;
            }

            //
            if(total != 30){ }
            else dfs(0);


            String temp = (flag) ? "1" :  "0";
            sb.append(temp + " ");

        }

        System.out.println(sb);

    }

    public static void dfs(int round){
        if(flag) return; // 가능하니 끝냄

        //15면 끝
        if(round == 15) {
            flag = true;
            return;
        }

        int t1 = team1[round];
        int t2 = team2[round];


        //승 무 패
        // team 1의 승리가 가능하다면
        if(games[t1][0] > 0 && games[t2][2]>0) {
            games[t1][0]--;
            games[t2][2]--;
            dfs(round+1);
            games[t1][0]++;
            games[t2][2]++;
        }
        // team 2의 승리가 가능하다면
        if(games[t1][2] > 0 && games[t2][0] >0) {
            games[t1][2]--;
            games[t2][0]--;
            dfs(round+1);
            games[t1][2]++;
            games[t2][0]++;
        }
        // team 1,2 가 무승부가 가능하다면
        if(games[t1][1] > 0 && games[t2][1] >0) {
            games[t1][1]--;
            games[t2][1]--;
            dfs(round+1);
            games[t1][1]++;
            games[t2][1]++;
        }
    }
}
