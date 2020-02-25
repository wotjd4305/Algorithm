package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class swe5688{
    static int N = 1000001;
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> Hm = new HashMap<>();


    public static void main(String[] args) {

        int answer = 0;
        int T = sc.nextInt();
        make_Dp(N);

        for(int t=0; t<T; t++) {


            long input = sc.nextLong();
            answer = solution(input);

            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static void make_Dp(int N)
    {

        for(int i =0; i<N; i++)
        {
            String bigOne = "" + (long)Math.pow(i,3);
            Hm.put(bigOne,i);
        }
    }

    public static int solution(long input)
    {
        String input_for_str = "" + input;

        if(Hm.containsKey(input_for_str))
            return Hm.get(input_for_str);
        else
            return -1;
    }



}