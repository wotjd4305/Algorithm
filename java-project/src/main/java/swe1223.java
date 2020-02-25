package main.java;

import java.util.Arrays;
import java.util.Scanner;

class swe1223{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int answer = 0;
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            // 테스트케이스 길이
            int N = sc.nextInt();
            String str = sc.next();
            String str_rear = "";

            // 초기화
            char stackOp[] = new char[N];
            String stackForOp[] = new String[N];
            int top = -1;
            answer = 0;

            //후위연산자만들기
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 해싱기법 가장빠른 검색!(상수시간)
                switch (c) {
                    case '*': // 스택에 2보다 작은 우선순위가 있을 떄까지 꺼내서 출력
                    case '/': // 낮은 우선순위가 나올때 까지..
                        while (top >= 0 && (stackOp[top] == '/' || stackOp[top] == '*')) {
                            str_rear +=stackOp[top--] + "";
                        }
                        stackOp[++top] = c;
                        break;
                    case '+': // 스택에 1보다 작은 우선순위가 있을 때 까지 꺼내서 출력
                    case '-':
                        while (top >= 0 && (stackOp[top] == '/' || stackOp[top] == '*' || stackOp[top] == '+'
                                || stackOp[top] == '-')) {
                            str_rear +=stackOp[top--] + "";
                        }
                        stackOp[++top] = c;
                        break;
                    default: // 피연산
                        str_rear +=str.charAt(i) + "";
                        break;
                }
            }
            while(top >= 0) {
                str_rear += stackOp[top--] + "";
            }


            //계산하기
            for(int i =0; i<str_rear.length(); i++ ) {
                String right;
                String left;
                char c = str_rear.charAt(i);
                switch (c) {
                    case '*':
                        right = stackForOp[top];
                        left = stackForOp[--top];
                        stackForOp[top] = Integer.parseInt(left) * Integer.parseInt(right) + "";
                        break;
                    case '+':
                        right = stackForOp[top];
                        left = stackForOp[--top];
                        stackForOp[top] = Integer.parseInt(left) + Integer.parseInt(right) + "";
                        break;
                    default: // 피연산
                        stackForOp[++top] = c + "";
                        break;
                }
            }


            System.out.println("#" + test_case + " " + stackForOp[0]);
        }
    }
}