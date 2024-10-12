package Temp_2023.level2;

import java.util.*;

public class L2_요격시스템 {
    public static void main(String args[]){

        int targets[][] = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets){

        int answer = 0;
       //   {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}} ->  {{1,4},{4,5},{3,7},{4,8},{5,12},{11,13},{10,14}};
        Arrays.sort(targets, (o1, o2) -> {return o1[1]- o2[1];});

        int end = targets[0][1];
        answer++;
        for(int i=1; i<targets.length; i++){
            if(targets[i][0] >= end) {
                end = targets[i][1];
                answer++;
            }
        }


        return answer;
    }
}
