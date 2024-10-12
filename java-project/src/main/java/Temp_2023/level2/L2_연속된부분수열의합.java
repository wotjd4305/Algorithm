package Temp_2023.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class L2_연속된부분수열의합 {
    public static void main(String args[]) {

        int[] seq = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(solution(seq, k));
    }

    public static int[] solution(int[] sequence, int k) {

        int left = 0;
        int right = 1;

        int[] answer = new int[]{0, sequence.length - 1};

        int total = sequence[0];

        while (left < right) {
            if (total == k) {
                change(right, left, answer);
                total -= sequence[left++];
            } else if (total > k) {
                total -= sequence[left++];
            } else if (right < sequence.length) {
                total += sequence[right++];
            } else {
                break;
            }

        }

        return answer;
    }

    private static void change(int right, int left, int[] answer) {
        if (right - 1 - left < answer[1] - answer[0]) {
            answer[0] = left;
            answer[1] = right - 1;
        }
    }
}
