package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bac2740 {

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Am, An;
        int Bm, Bn;
       int A[][];
       int B[][];
       int C[][];

       Am = sc.nextInt();
        An = sc.nextInt();
        sc.nextLine();
        A = new int[Am][An];

       for(int i=0; i<Am; i++)
        {
            for(int j=0; j<An; j++)
            {
                A[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

       Bm = sc.nextInt();
       Bn = sc.nextInt();
       sc.nextLine();
       B = new int[Bm][Bn];

       for(int i=0; i<Bm; i++)
       {
           for(int j=0; j<Bn; j++)
           {
               B[i][j] = sc.nextInt();
           }
           sc.nextLine();
       }

       //곱셈
       // C(1,1) = A(1,1)*B(1,1) + A(1,2)*B(2,1)
       // C(1,2) = A(2,1)*B(1,2) + A(2,2)*B(2,2)
       // C(1,3) = A(3,1)*B(1,3) + A(3,2)*B(2,3)

       // C(2,1) = A(2,1)*B(1,1) + A(2,2)*B(2,1)
       // C(2,2) = A(2,1)*B(2,1) + A(2,2)*B(2,2)
       // C(2,3) = A(2,1)*B(3,1) + A(2,2)*B(2,3)
 C = new int[Am][Bn];
       for(int i=0; i<Am; i++) {
           for (int j = 0; j <Bn ; j++) {
               for (int k = 0; k < An; k++) {
                   C[i][j] += A[i][k] * B[k][j];
               }
           }
       }

       //ShowArr(A,Am,An);
       //ShowArr(B,Bm,Bn);
       ShowArr(C,Am,Bn);






   }

    public static void ShowArr(int[][] Arr, int m, int n)
    {
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(Arr[i][j] + " ");
            }
            System.out.println();
        }
    }




}

