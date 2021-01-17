package main.java.Temp2;

import java.util.Arrays;
import java.util.Scanner;

public class swe3304 {

   static int Arr[][];
   static char cArr[][];
   static int answer = 0;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //테스트케이스
        for(int t=0; t<T; t++) {

            //초기화
            Arr = new int[1001][1001];
            cArr = new char[2][1001];
            answer = 0;

            //
            String strA = sc.next();
            String strB = sc.next();

            //A배열에 넣기
            for(int i =0; i<strA.length(); i++)
            {
                cArr[0][i] = strA.charAt(i);
            }

            //B배열에 넣기
            for(int i =0; i<strB.length(); i++)
            {
                cArr[1][i] = strB.charAt(i);
            }

            answer = LCS(strA.length(), strB.length());
            //P(strA.length(), strB.length());
            System.out.println("#" + (t+1) + " " + answer);


        }


    }



    public static int LCS(int A_length, int B_length)
    {
        for(int i =1; i<=A_length; i++)
        {
            for(int j=1; j<=B_length; j++)
            {
                if(cArr[0][i-1] == cArr[1][j-1])
                    Arr[i][j] = Arr[i-1][j-1] +1;
                else
                    Arr[i][j] = Math.max(Arr[i-1][j], Arr[i][j-1]);


            }
        }

        return Arr[A_length][B_length];
    }

    public static void P(int A_length, int B_length)
    {
        for(int i =0; i<=A_length; i++)
        {
            for(int j=0; j<=B_length; j++)
            {
                System.out.print(Arr[i][j] + " ");

            }
            System.out.println();
        }
    }



}

