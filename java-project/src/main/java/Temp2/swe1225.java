package main.java.Temp2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class swe1225 {
    static Queue<Integer> Qu = new LinkedList<>();

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 초기화
        String answer = "";

        // 테스트케이스
        for (int test_case = 1; test_case <= 10; test_case++) {

            // 초기화 및 첫 문자 생략
            sc.nextInt();
            answer = "";
            Qu.clear();
            int btn = 0;

            // 입력
            for (int i = 0; i < 8; i++) {
                Qu.offer(sc.nextInt());
            }

            // 끝자리가 0이 나올때 까지.
            while (true) {
                // 1,2,3,4,5 차례로 감소
                for (int i = 1; i <= 5; i++) {
                    // 1)뺴고
                    int front_out = Qu.poll();
                    front_out -= (i);

                    // 1-1)감소되고 다시 넣기 전, 0보다 작으면 0넣고 끝내
                    if (front_out <= 0) {

                        Qu.offer(0);
                        btn = 1;
                        break;
                    }

                    // 2)넣고
                    Qu.offer(front_out);
                }
                // 0 혹은 더작은 값이 나오면 끝내
                if (btn == 1)
                    break;
            }

            // 암호문 합치기
            for (int i : Qu) {
                answer += i + " ";
            }

            // 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }
}