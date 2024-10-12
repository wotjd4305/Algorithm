package Temp_2023;

import java.util.*;

public class L1_정렬_K번째수 {

    public static void main(String args[]) {
        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = solution(array, commands);

        for(int a : result){
            System.out.print(a + " ");
        }
    }


    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int counter = 0;
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

        int firstIdx = 0;
        for (int[] a : commands) {
            int temp[] = Arrays.copyOfRange(array, commands[firstIdx][0]-1, commands[firstIdx][1]);

            for(int b : temp){
                Q.add(b);
            }

            for(int b =0; b<commands[firstIdx][2]-1; b++){
                Q.poll();
            }

            answer[counter++] = Q.poll();

            while(!Q.isEmpty()){
                Q.poll();
            }
            firstIdx++;
        }
        return answer;
    }
}
