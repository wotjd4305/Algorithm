package main.java.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_0504_Algo1_서울_11반_박재성 {

    static int Money;
    static int Time;
    static int T;

    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            Money = Integer.parseInt(st.nextToken()); // 시급
            Time = Integer.parseInt(st.nextToken()); // 시간
            int total_money = Money * Time; // 총 가격

            if (total_money % 10 != 0) // 정확하게 못주는경우
                System.out.println("#" + (test) + " -1");
            else { // 정확하게 줄 수 있는 경우
                coins = new int[3];
                solution(total_money); //솔루션
                System.out.println("#" + (test) + " " + coins[0] + " " + coins[1] + " " + coins[2]); //출력
            }
        }
    }

    //400 100 10
    private static void solution(int total_money) {
        while (true) {
            //종료문
            if (total_money == 0)
                break;
            if (total_money >= 400) {
                coins[0] = total_money / 400;
                total_money %= 400;
            } else if (total_money >= 100) {
                coins[1] = total_money / 100;
                total_money %= 100;
            } else {
                coins[2] = total_money / 10;
                total_money %= 10;
            }
        }
    }
}