package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

public class 동전거스름돈_dp {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] c = new int [N+1];

        //1원짜리 고려한것만 들어가있겠죠
        for(int i =0; i< c.length; i++){
            c[i] = i; //1원짜리 필요한 개수
        }

        //1,4 원
        for(int i=4; i<c.length; i++){
            //c[i] = 1원짜리만 고려한 최소개수
            //c[i-4]+1 = 1원,4원 고려한 최소개수
            if(c[i] > c[i-4]+1){
                c[i] = c[i-4]+1;
            }
        }
        //1,4,6 원
        for(int i=6; i<c.length; i++){
            //c[i] = 1,4원을 고려한 최소개수
            //c[i-6]+1 = 1원,4원,6원 고려한 최소개수
            if(c[i] > c[i-6]+1){
                c[i] = c[i-6]+1;
            }
        }

        System.out.println(Arrays.toString(c));
        System.out.println(c[N]);


    }
}
