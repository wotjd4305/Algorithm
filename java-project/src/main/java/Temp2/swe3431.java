package main.java.Temp2;

import java.util.ArrayList;
import java.util.Scanner;

public class swe3431 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer;

        //테스트케이스
        for(int t=0; t<T; t++) {
            answer = 0;

            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();

            answer = solution(L,U,X);
            System.out.println("#" + (t+1) + " " + answer);

        }


    }

    public static int solution(int L, int U, int X)
    {
        if(X < L)
            return L-X;
        if(U < X)
            return -1;
        else
            return 0;
    }


}

