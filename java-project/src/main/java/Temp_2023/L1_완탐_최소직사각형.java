package Temp_2023;

import java.util.*;

public class L1_완탐_최소직사각형 {

    public static void main(String args[]) {
        int sizes[][] = {{60,50},{30,70},{60,30},{80,40}};

        System.out.println(solution(sizes));
    }


    public static int solution(int[][] sizes) {
        int prevMax = 0;
        int prevMin = 0;

        for (int[] size: sizes) {
            int curMax = Math.max(size[0], size[1]);
            int curMin = Math.min(size[0], size[1]);

            prevMax = Math.max(curMax, prevMax);
            prevMin = Math.max(curMin, prevMin);
        }

        return prevMax * prevMin;
    }
}
