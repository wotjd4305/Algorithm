package main.java;

import java.util.HashMap;
import java.util.Scanner;

public class swe1860 {
    static Scanner sc  = new Scanner(System.in);
    static String answer = "";
    static HashMap<Integer, Integer> Hm;

    public static void main(String[] args) {


        int t = sc.nextInt();
        for(int T=1; T<=t; T++) {
            answer = "";
            Hm = new HashMap<>();

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int arriveTime;

            for(int i=0; i<N; i++)
            {
                arriveTime = sc.nextInt();
                Hm.put(arriveTime, Hm.getOrDefault(arriveTime, 0) +1);
            }

            answer = solution(N,M,K);
           // Pt();

            System.out.println("#" + T + " " + answer);
        }
    }

    public static void Pt()
    {
        for(int i : Hm.keySet())
            System.out.println(i + "--" + Hm.get(i));
    }


    public static String solution(int N, int M, int K)
    {
        int stock =0;
        int count =0;
        int last_order =0;

        for(int i : Hm.keySet())
            last_order = Math.max(i,last_order);

        if(Hm.containsKey(0))
            return "Impossible";

        while(true)
        {
            count++;
            //시간이 맞으면
            if((count%M) == 0)
            {
                stock += K;
            }

            //도착한사람, 없으면 0을뺌
            if(Hm.containsKey(count)) {
                stock = stock - Hm.get(count);

            }
            if(stock < 0)
            {
                return "Impossible";
            }
            //마지막사람
            if(last_order == count)
                break;
        }
        return "Possible";

    }



}
