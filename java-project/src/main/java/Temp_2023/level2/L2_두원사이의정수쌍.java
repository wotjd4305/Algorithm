package Temp_2023.level2;

import java.util.Arrays;

public class L2_두원사이의정수쌍 {
    public static void main(String args[]){

        int r1 = 2;
        int r2 = 3;
        System.out.println(solution(r1, r2));
    }

    public static int solution(int r1, int r2){
        int answer=0;

        // 4개의 사분면 중 1개만 구한뒤 4를 곱한다.
        for( int i = 1; i <= r2 ; i++){
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            answer += ( (long)y2 - (long)Math.ceil(y1) + 1);
        }
        answer *= 4;

        return answer;
    }
}
