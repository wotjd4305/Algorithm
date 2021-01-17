package TextBook;

import java.util.Arrays;
import java.util.Scanner;

public class C01_BasicTest {

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
        combination(0,0);
        System.out.println("총 경우의 수 : " + totalCnt);
    }

    //현재 위치에 조합할 수 선택.
    private static void combination(int cnt, int cur){

        //기저 조건
        //cnt == R은 다뽑은것.
        if(cnt == R){
            totalCnt++;
            System.out.println(Arrays.toString(number));
            return;
        }
       for(int i = cur; i<N; i++){
           number[cnt] = input[i];
           combination(cnt+1,i+1);//현재수의 다음수부터 시작하도록.
       }
    }
}
