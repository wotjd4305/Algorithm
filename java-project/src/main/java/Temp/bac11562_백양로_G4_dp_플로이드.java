import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bac11562_백양로_G4_dp_플로이드 {

    static int N;
    static int M;

    static int dir[][];

    static final int m = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dir = new int[N+1][N+1];

        for(int row[] : dir) Arrays.fill(row, m);
        for(int i=1; i<=N; i++)
            dir[i][i] = 0;

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c == 1) {//양방
                dir[a][b] = 0;
                dir[b][a] = 0;
            }else {//일방
                dir[a][b] = 0;
                dir[b][a] = 1;
            }
        }


        //b = 0 | 1(일방 | 양방)
        //가는 방향이 반대인 것은 플러스
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(k==i) continue;
                for(int j=1; j<=N; j++){
                    if(j == i || k == j) continue; //중복제거

                    dir[i][j] = Math.min(dir[i][k] + dir[k][j] , dir[i][j]);
                }
            }
        }

        //마지막 질문 수
        int K = Integer.parseInt(br.readLine());
        for(int i =0; i< K; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dsc = Integer.parseInt(st.nextToken());
            sb.append(dir[src][dsc]+"\n");
        }
        System.out.println(sb);

    }

}