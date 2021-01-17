package main.java.Temp2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swe3750 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        String answer;

        //테스트케이스
        for(int t=0; t<T; t++) {

            //초기화
            answer = "";
            String N = sc.next();


            answer = recursive(N);

            System.out.println("#" + (t+1) + " " + answer);

        }


    }

    public static String recursive(String N)
    {
        int buffer =0;
        if(N.length() != 1)
        {
            for(int i =0; i<N.length(); i++)
            {
                buffer += Integer.parseInt(N.substring(i,i+1));
            }
            return recursive("" + buffer);
        }
        else
        {
            return N;
        }

    }


}

