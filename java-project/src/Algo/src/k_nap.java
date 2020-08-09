package Algo.src;

import java.util.Arrays;

public class k_nap {
    public static void main(String args[]) {
        int W = 10;
        int[] w = {0, 5, 4, 6, 3};
        int[] v = {0, 10, 40, 30, 50};
        int[][] K = new int[w.length][W + 1];

        for (int i = 0; i < K.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                K[i][j] = K[i-1][j];
            }
            for (int j = w[i]; j <= W; j++) {
                int now = K[i-1][j - w[i]] + v[i];
                int pre = K[i-1][j];
                K[1][j] = now >= pre ? now : pre;
            }
        }

        for(int i=0; i<K.length;i++){
            System.out.println(Arrays.toString(K[i]));
        }
    }
}
