package main.java.test;

import java.util.Scanner;

public class b_0402_Algo1_서울_11반_박재성 {

    //T는 테스트케이스수
    //amount는 배달해야할 양
    //answer는 최소의 봉지수
    static int T;
    static int amount;
    static int answer;

    public static void main(String args[]) {

        //입력 스캐너 생성
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();//T입력

        //테스트케이스 갯수 만큼 반복.
        for(int i =0; i<T; i++) {
            amount = sc.nextInt();//배달할양 입력

            //처리부
            solution();

            //출력부
            System.out.println(answer);
        }

    }


    public static void solution() {

        //1)5로 다 나누어 떨어졌을 경우?
        //가장 최소의 봉지수임은 자명.
        if(amount%5 == 0) {
            answer = amount/5;
            return;
        }

        //2)5를 가장많이 쓰는것 부터 1개까지 쓰는것까지 반복할것임.
        //5가 0이면 while벗어나고, '3)'으로
        //f_c는 5카운트
        int f_c=amount/5;

        while(true) {
            //종료문
            if(f_c == 0)
                break;

            //반복문
            //temp는 5가 들어가고 남은것
            int temp = amount-(f_c*5);
            if(temp % 3 == 0) { //3으로 나뉜다는것은 조합이가능하다는것.
                answer = f_c + (temp/3); //봉지 갯수 구하기.
                return;
            }


            //증감, 종료문을 향해서..
            f_c--;
        }

        //3)마지막으로 3까지 내려왔을 때, 나누어 떨어진다면?
        //가장 많은 봉지수 이지만, 가능은함.
        //3-else) 가능한 경우의 수가 없다? -1 출력.
        if(amount%3 == 0) answer = amount/3;
        else answer = -1;
        return;
    }
}