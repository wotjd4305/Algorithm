package main.java.Temp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class temp3 {
    static Scanner sc  = new Scanner(System.in);
    static int answer = 0;
    static ArrayList<Integer> AL;

    public static void main(String[] args) {


        int t = sc.nextInt();
        for(int T=1; T<=t; T++) {
            answer = 0;
            AL = new ArrayList<>();
            int N = sc.nextInt();

            for(int i=0; i<N; i++)
            {
                AL.add(sc.nextInt());
            }

            answer = solution(N);
            System.out.println("#" + T + " " + answer);
        }
    }

    public static void Pt()
    {
        for(int i : AL)
            System.out.println("값 : " + i);
    }


    public static int solution(int N)
    {
        int last = 0;
        int total = 0;
        int min = 999999;
        for(int i : AL)
            last = Math.max(last, i);

        //System.out.print(last);

        for(int i =1; i<=last; i++)
        {
            total = 0;
            for(int homeLocation : AL)
            {
                total += Math.abs(homeLocation - i);
            }

            min = Math.min(total, min);

        }


        return min;
    }



}
