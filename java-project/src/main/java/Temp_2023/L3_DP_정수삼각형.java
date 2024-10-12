package Temp_2023;

import java.util.Arrays;
import java.util.Comparator;

public class L3_DP_정수삼각형 {

    public static void main(String args[]) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }


    // 1,0 1,1
    // 2,0 2,1 2,2
    public static int solution(int[][] triangle) {

        for (int i = 0; i < triangle.length; i++) {
            if (i == 0) continue;
            System.out.println(triangle[i].length);
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] += triangle[i - 1][0];
                } else if (j == triangle[i].length-1) {
                    triangle[i][j] += triangle[i - 1][triangle[i - 1].length-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
            showArray(triangle);
        }
        int result = Integer.MIN_VALUE;
        for(int a : triangle[triangle.length-1]){
            result = Math.max(result, a);
        }
        return result;
    }

    public static void showArray(int[][] Array) {
        for (int[] i : Array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
