package main.java.Temp2;

import java.util.ArrayList;
import java.util.Scanner;

public class swe5603 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int idx = 1;
        ArrayList<Integer> AL = new ArrayList<>();


        //테스트케이스
        for(int t=0; t<T; t++) {
            int N = sc.nextInt();
            int mid = 0;
            int answer = 0;

            //값받기
            for(int i=0; i<N; i++)
            {
                AL.add(sc.nextInt());
            }

            //중간값구하기
            for(int i=0; i<N; i++)
            {
                mid += AL.get(i);
            }
            mid /= N;

            for(int i : AL)
            {
                if((i - mid) > 0)
                    answer += (i-mid);
            }

            AL.clear();

            System.out.println("#" + (idx++) + " " + answer);
        }


    }



}

