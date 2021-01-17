package main.java.Temp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class swe4371 {
    static Scanner sc = new Scanner(System.in);
    static long Arr[];
    static int N;
    static Boolean B_Arr[];


    public static void main(String[] args) {
        int T = sc.nextInt();
        int answer = 0;

        for(int t=0; t<T; t++) {

            //초기화, Boolean값은 거짓.

            Arr = new long[5000];
            N = sc.nextInt();

            //입력
            for(int i=0; i<N; i++)
            {
                Arr[i] = sc.nextLong();
            }

            if(N==1 || N==2)
                System.out.println("#" + (t+1) + " " + 1);
            else
                {
                //갯수만큼 돌리자.
                B_Arr = new Boolean[5000];
                Arrays.fill(B_Arr, false);

                answer = Solution();
                System.out.println("#" + (t + 1) + " " + answer);
            }
        }

    }

    public static int Solution()
    {
        int count = 1;
        int idx = 1;
        int AL_len = N;
        long gap =  Arr[idx] - Arr[0];

        //다돌때까지
        while(true)
        {
            make_true(idx, gap,AL_len);
            if (isEnd(AL_len))
                break;

            //중복안되는 녀석. 찾을때까지
            for(int j=idx; j<AL_len; j++)
            {
                //System.out.println("So");
                if(B_Arr[j] == false)
                {
                    idx = j;
                    count++;
                }
            }
            gap = Arr[idx] - Arr[0];
        }
        return count;
    }

    //배가 모두 돌았다면 참 리턴.
    public static Boolean isEnd(int AL_len)
    {
        for(int i=1; i<AL_len; i++)
        {
            if(B_Arr[i] == false)
            {
                return false;
            }
        }

        return true;
    }

    public static void make_true(int idx, long gap, int AL_len)
    {
        long sum = 1;
        sum += gap;

        for( int i=idx; i<AL_len; i++)
        {
            if(Arr[i] == sum)
            {
                B_Arr[i] = true;
                sum += gap;
            }
        }

    }


}

