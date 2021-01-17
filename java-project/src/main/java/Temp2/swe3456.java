package main.java.Temp2;

import java.util.*;

public class swe3456 {

    static Queue<Integer> Buffer_Q = new LinkedList<>();
    static HashMap<Integer, Integer> Hm = new HashMap<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int T = sc.nextInt();
        int answer;

        //테스트케이스
        for(int t=0; t<T; t++) {

            //초기화
            int N = 3;
            Buffer_Q.clear();
            Hm.clear();
            answer = 0;

            //입력
            answer = solution(N);

            System.out.println("#" + (t+1) + " " + answer);

        }


    }

    public static int solution(int N)
    {
        //입력
        for(int i =0; i<N; i++)
        {
            Buffer_Q.offer(sc.nextInt());
        }

        while(!Buffer_Q.isEmpty())
        {
           Hm.put(Buffer_Q.peek(), Hm.getOrDefault(Buffer_Q.poll(), 0)+1);
        }


        for(int i : Hm.keySet())
        {
            if(Hm.get(i) % 2 == 1)
                return i;
        }

        return 0;
    }


}

