package main.java.Temp2;

import java.util.HashMap;
import java.util.Scanner;

public class swe2948 {
    static Scanner sc  = new Scanner(System.in);
    static int K;
    static int N;
    static int answer=0;
    static HashMap<String, Integer> Am;
    static HashMap<String, Integer> Bm;


    public static void main(String[] args) {


        int t = sc.nextInt();
        //N개의 퀸이 N*N배열
        for(int T=1; T<=t; T++) {
            N = sc.nextInt();
            K = sc.nextInt();
            Am = new HashMap<>();
            Bm = new HashMap<>();

            answer = 0;

            //Am채우기
            for(int i=0; i<N; i++)
            {
                Am.put(sc.next(), 1);
            }

            //Bm채우기
            for(int i=0; i<K; i++)
            {
                Bm.put(sc.next(), 1);
            }
            solution();

            System.out.println("#" + T + " " + answer);
        }
    }

    public static void solution()
    {
        for(String str : Am.keySet())
        {
            if(Bm.containsKey(str))
            {
              answer++;
            }
        }

    }


}
