package main.java.test;

import java.util.Arrays;

public class 다익스트라 {
    final static int M = Integer.MAX_VALUE;

    public static void main(String args[]){

        int[][] G = {
                {0,3,5,M,M,M},
                {M,0,2,6,M,M},
                {M,1,0,4,6,M},
                {M,M,M,0,2,3},
                {3,M,M,M,0,6},
                {M,M,M,M,M,0}
        };

        int s = 0;
        int D[] = G[s];
        boolean used[] = new boolean[G.length];
        used[s] = true;

        for(int i=1; i<G.length; i++){
            int minindex = -1;
            int min_value = M;

            //가장 작은
           for(int j=0; j<used.length; j++){
                if(!used[j] && D[j] < min_value) {
                    min_value = D[j];
                    minindex = j;
                }
            }
            used[minindex] = true;

           //
            for(int j = 0; j<D.length; j++){
                if(!used[j] && G[minindex][j] != M && D[j] > D[minindex] + G[minindex][i]){
                    D[j] = D[minindex] + G[minindex][j];
                }
            }
        }

        System.out.println(Arrays.toString(D));

    }


}
