package Algo.src;

import java.util.Scanner;

public class Solution5 {

   static int answer;
   static int[] Arr;
   static int[] opt;
   static Scanner sc = new Scanner(System.in);
   static int Ncount;

    public static void main(String[] args) {
        int T = sc.nextInt();

        //�׽�Ʈ���̽�
        for(int t=0; t<T; t++) {

            answer = 0;
            Ncount = sc.nextInt();
            Arr = new int[Ncount];
            opt = new int[Ncount];

            LIS(Ncount);

            System.out.println("#" + (t+1) + " " + answer);
        }
    }

    
    public static void LIS(int N)
    {
        for(int i=0; i<N; i++ )
        {
            Arr[i] = sc.nextInt();
        }    
        for(int i=0; i<N; i++)
        {
            opt[i] = 1;
            for(int j=0; j<i; j++)
            {
                if(Arr[j] < Arr[i] && opt[i] < opt[j] +1)
                {
                    opt[i] = opt[j] +1;
                }
                answer = Math.max(opt[i], answer);
            }
        }
    }
}

