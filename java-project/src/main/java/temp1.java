package main.java;

import java.util.ArrayList;
import java.util.Scanner;

public class temp1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //테스트케이스
        for(int t=0; t<T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int count = 0;

            String forM = "" +M;
            char cM = forM.charAt(0);

            for(int i =0; i<=N; i++)
            {
                String buffer = "" + i;

                for(int j =0; j<buffer.length(); j++)
                {
                 if(cM == buffer.charAt(j))
                     count++;
                }
            }

            System.out.println("#" + t + " - " + count);

        }


    }
}

