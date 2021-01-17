package main.java.Temp2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swe3499 {

    static Queue<String> Que1 = new LinkedList<>();
    static Queue<String> Que2 = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        String answer;

        //테스트케이스
        for(int t=0; t<T; t++) {

            //초기화
            double N = sc.nextDouble();
            int Temp = (int)Math.round(N/2);
            Que1.clear();
            Que2.clear();
            answer = "";


            for(int i =0; i<Temp; i++)
            {
                Que1.offer(sc.next());
            }
            for(int i=Temp; i<N; i++)
            {
                Que2.offer(sc.next());
            }

            answer = solution();

            System.out.println("#" + (t+1) + " " + answer);

        }


    }

    public static String solution()
    {
        String buffer = "";

        while(true)
        {
            if(!Que1.isEmpty())
                buffer = buffer + Que1.poll() + " ";
            if(!Que2.isEmpty())
                buffer = buffer + Que2.poll() + " ";

            if(Que1.isEmpty() && Que2.isEmpty())
                break;
        }

        return buffer;
    }


}

