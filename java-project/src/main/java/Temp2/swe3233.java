package main.java.Temp2;

import java.util.Scanner;

public class swe3233 {
    static Scanner sc = new Scanner(System.in);
    static long answer = 0;
    public static void main(String[] args)
    {
        solution();
    }

    public static void solution()
    {
        int t = sc.nextInt();
            for(int T=1; T<=t; T++) {
                 int A = sc.nextInt();
                 int B = sc.nextInt();

                 answer = Print_value(A,B);
                 System.out.println("#" + T + " " + answer);

        }

    }

    public static long Print_value(int A, int B)
    {
        double valueToPow = Math.round(A/B);
        double result = Math.pow(valueToPow, 2.0);

        return Math.round(result);

    }

}

