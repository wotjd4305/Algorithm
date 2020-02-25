package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe4789 {
      static Boolean P_Arr[];
      static ArrayList<Integer> AL = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int answer;

        //테스트케이스
        for(int t=0; t<T; t++) {

            String Num = sc.next();
            answer = Solution(Num);
            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static int Solution(String Num)
    {
        int answer = 0;

        answer = zero_ct(Num);
        return answer;
    }

    public static  int zero_ct(String Num)
    {
        int ct =0;
        for(int i=0; i<Num.length();)
        {
            System.out.println("first" + i);
            if( Num.charAt(i) == '0')
            {
                System.out.println("idx" + i);
                i++;
                ct++;
                //System.out.println("if" + i);

            }
            else
            {
                //System.out.println(Integer.parseInt("" + Num.charAt(i)));
                int buffer_i = i;
                //System.out.println("else" + i);

                for(int j =buffer_i;
                     j < Num.length() && j< (i + Integer.parseInt("" + Num.charAt(j)));
                    j++)
                {
                    //System.out.println("else - for" + i);
                    i += Integer.parseInt("" + Num.charAt(j));
                }

            }
        }

        return ct;
    }

}

