package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class swe1220 {
    static Scanner sc  = new Scanner(System.in);
    static int answer;
    public static void main(String[] args) {
        for(int T=1; T<=10; T++) {
            answer = 0;
            int tsize = sc.nextInt();
            sc.nextLine();
            int[][] Arr = new int[tsize][tsize];
            Boolean[][] Arr_B = new Boolean[tsize][tsize];

            //입력
            for(int i=0; i<tsize; i++)
            {
                for(int j=0; j<tsize; j++)
                {
                    Arr[i][j] = sc.nextInt();
                    Arr_B[i][j] = false;
                }
            }

            //1이 N극 2가 S극
            //N극이 북쪽, S극이 남쪽
            //배열을 도는중 N극 밑에 S극이 있어야 교착
            //입력
            for(int i=0; i<(tsize-1); i++)
            {
                for(int j=0; j<tsize; j++)
                {
                    //N극이고 밑에 S극이 있냐
                    if(Arr[i][j] == 1)
                    {
                        for (int k = i + 1; k < tsize; k++)
                            if(Arr[k][j] == 2)
                            {
                                if(Arr_B[k][j] == true)
                                    break;

                                Arr_B[k][j] = true;
                                answer++;
                                break;
                            }
                    }
                }
            }


            System.out.println("#" + T + " " + answer);
        }
    }
}