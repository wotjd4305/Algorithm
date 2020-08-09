package Algo.src;

import java.util.Arrays;
import java.util.Scanner;

public class P03_NextPemutation {

    static int N;
    static int[] input;
    static int totalCnt;

    //중복값도 가능.
    //수들의 교환
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        for(int i = 0; i<N; i++){
            input[i] = sc.nextInt();
        }

        //시작 : 가장 작은 순열
        Arrays.sort(input);

        //nextPermtation()을 부르면 배열이 날아감
        do{
            System.out.println(Arrays.toString(input));
        }while(nextPermutation());
        System.out.println("총 경우의 수 : " + totalCnt);

    }

    private static boolean nextPermutation(){
        //불린 횟수
        totalCnt++;

        //step1
        int i = N-1;
        //i-1은 직전 위치
        //뒤에서 시작.
        while(i>0  && input[i-1] >= input[i]){ --i;
            if(i==0){ //꼭대기까지 갔으나 없으니, 더이상의 순열 못만들어요
                return false;
            }
        }

        //step2
        //교환할 자리하고, 앞쪽에서 올라오는애랑 큰값을 첫번쨰로만날떄
        int j = N-1;
        while(input[i-1] >= input[j]) --j;

        //step3
        //스왑
        int temp = input[i-1];
        input[i-1] = input[j];
        input[j] = temp;

        //step4
        //꼭대기니까 맨밑에까지 내려갑시다
        //i와 k가 한자리에서 만나면 끝
        int k = N-1;
        while(i<k){
            temp = input[i];
            input[i] = input[k];
            input[k] = temp;
            ++i;
            --k;
        }

        return true;

    }
}
