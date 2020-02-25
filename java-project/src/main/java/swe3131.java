package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe3131 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    static int Arr[];
    static ArrayList<Integer> AL = new ArrayList<>();

    public static void main(String[] args)
    {
        solution();

    }

    public static void solution()
    {
        //100만
        int N = 1000000;
        Arr= new int[N+1];
        Arrays.fill(Arr, 0);
        Prime(N);

        for(int i : AL)
        {
            System.out.print(i + " ");
        }

    }

    public static void Prime(int N)
    {
        for(int i=2; i<=N; i++)
        {
            if(Arr[i] == 0)
            {
                AL.add(i);
                for(int j = i; j<=N; j += i)
                {
                    Arr[j] = 1;
                }
            }
        }
    }

}

