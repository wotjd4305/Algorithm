package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

public class C02_BasicTest2 {

    static int N,R;
    static int[] input,number;
    static int totalCnt;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();

        input = new int[N];
        number = new int[R];
        for(int i = 0; i<N; i++){
            input[i] = sc.nextInt();
        }
        combination(N,R);
        System.out.println("총 경우의 수 : " + totalCnt);
    }

    //n번쨰 원소를 r위치(순서)에 조합해보기.
    //3C2 -> 2C1(3원소 V)+ 2C2(3원소 X)
    private static void combination(int n, int r){

        //조합을 할수없는 상황
        //아래의 두가지.
        //1)1C0 이거나 2)1C2(1개중에 두개를 못뽑잖아!)
        if(r == 0){
            ++totalCnt;
            System.out.println(Arrays.toString(number));
            return;

        }
        if(n<r){
            return;
        }

        //선택
        number[r-1] = input[n-1];
        combination(n-1,r-1);
        //비선택
        combination(n-1,r);
    }
}
