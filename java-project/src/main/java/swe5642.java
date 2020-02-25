package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swe5642 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        int T = sc.nextInt();
        ArrayList<Integer> AL = new ArrayList<>();


        //테스트케이스
        for(int t=0; t<T; t++) {
            int N = sc.nextInt();

            //리스트에 값받기
            for (int i = 0; i < N; i++) {
                AL.add(sc.nextInt());
            }

            //리스트를 배열로
            int[] A = new int[AL.size()];
            for(int i=0; i<A.length; i++)
            {
                A[i] = AL.get(i);
            }

            int answer = MakeDp(A);

            System.out.println("#"+ (idx++) + " " + answer);

            AL.clear();



        }


    }

    public static int MakeDp(int[] Array)
    {
        int max = -9999;
        for(int i =1; i<Array.length; i++)
        {
            if(Array[i-1] > 0 && (Array[i] + Array[i-1]) > 0)
            {
                Array[i] += Array[i-1];
            }
            if(Array[i] > max)
                max = Array[i];

        }
        //예외
        if(Array[0] > max)
            max = Array[0];


        return max;
    }


}

