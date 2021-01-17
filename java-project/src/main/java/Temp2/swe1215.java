package main.java.Temp2;

import java.util.Scanner;
import java.util.*;

public class swe1215 {
    static Scanner sc  = new Scanner(System.in);
    static int answer = 0;
    static StringBuffer SB = new StringBuffer();

    public static void main(String[] args) {
        //split을 이용한 문자열이 포함된 숫자세기
        for(int T=1; T<=10; T++) {
            int number = sc.nextInt();
            int N = 8;
            sc.nextLine();

            //초기화
            char[][] Arr = new char[N][N];
            for(int i=0; i<N; i++)
            {
                String strRow = sc.nextLine();
                for(int j=0; j<N; j++)
                {
                    Arr[i][j] = strRow.charAt(j);
                }
            }

            rowFirst(Arr, number, N);
            columFirst(Arr, number, N);


            System.out.println("#" + T + " " + answer );
            answer = 0;
        }
    }

    public static void rowFirst(char[][] Arr, int number, int N)
    {
        String buffer = "";
        String buffer_Reverse ="";
        for(int i =0; i<N; i++)
        {
            for(int j=0; (j+number)<=N; j++)
            {
                for(int k=0; k<number; k++)
                {
                    buffer += Arr[i][j+k];
                }

                SB = new StringBuffer(buffer);
                buffer_Reverse = SB.reverse().toString();
                System.out.print(buffer);
                System.out.println(" " + buffer_Reverse);

                if(buffer.equals(buffer_Reverse))
                {
                    System.out.println( " " + "Same");
                    answer++;
                }

                //다음 작업을 위한 초기화
                buffer ="";
                buffer_Reverse ="";

            }
        }
    }


    public static void columFirst(char[][] Arr, int number, int N)
    {
        String buffer = "";
        String buffer_Reverse ="";
        for(int i =0; i<N; i++)
        {
            for(int j=0; (j+number)<=N; j++)
            {
                for(int k=0; k<number; k++)
                {
                    buffer += Arr[j+k][i];
                }

                SB = new StringBuffer(buffer);
                buffer_Reverse = SB.reverse().toString();
                System.out.print(buffer);
                System.out.println(" " + buffer_Reverse);

                if(buffer.equals(buffer_Reverse))
                {
                    System.out.println( " " + "Same");
                    answer++;
                }

                //다음 작업을 위한 초기화
                buffer ="";
                buffer_Reverse ="";

            }
        }

    }

}