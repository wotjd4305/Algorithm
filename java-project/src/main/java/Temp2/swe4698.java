package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swe4698 {
      static Boolean P_Arr[];
      static ArrayList<Integer> AL = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int D;
        int A;
        int B;
        int answer;
        int max = 1000000;

        //초기화
        P_Arr = new Boolean[max+1];
        Arrays.fill(P_Arr, false);
        make_prime(max);


        //테스트케이스
        for(int t=0; t<T; t++) {

            //입력
            D = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();

            answer = Solution(D, A, B);
            System.out.println("#"+ (t+1) + " " + answer);
        }


    }

    public static int Solution(int D, int A, int B)
    {
        int answer = 0;

        for(int i : AL)
        {
            if(!((i >= A) && (i <= B)))
                continue;
            else
            {
                String buffer = "" +i;
                String dst = "" + D;
                System.out.println(D);
                if((buffer).contains(dst))
                {
                    System.out.println(i);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void make_prime(int B)
    {
        P_Arr[2] = false;
        for(int i = 2; i<=B; i++)
        {
            if(P_Arr[i] == false)
            {
                AL.add(i);
                for(int j=i; j<=B; j+=i)
                {
                    P_Arr[j] = true;
                }
            }

        }
    }
}

