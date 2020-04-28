package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac13458_시험감독_B2 {

    static int N;
    static int[] A;
    static int B;
    static int C;

    static long answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N입력과 초기화
        answer = 0;
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken()); //총감독간 감시인원
        C = Integer.parseInt(st.nextToken()); // 부감독간 감시인원

        for(int i=0; i<N; i++){
            answer++;
            if(A[i] > B) {
                answer += (A[i] - B )/C;
                if((A[i] - B) % C != 0)
                    answer++;
            }
            else continue;
        }


        System.out.println(answer);
    }
}
