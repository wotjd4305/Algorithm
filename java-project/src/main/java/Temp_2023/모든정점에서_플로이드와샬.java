package Temp_2023;

import java.util.Arrays;

public class 모든정점에서_플로이드와샬 {
    static final int M = Integer.MAX_VALUE;

    public static void main(String[] args){
        int[][] D = {{0,M,2,3},
                {4,0,1,8},
                {2,5,0,M},
                {M,9,6,0}
        };

        for (int k=0; k<D.length; k++){
            for(int i=0; i<D.length; i++){
                if(k==i) continue;
                for(int j=0; j<D.length; j++){
                    if(i==j || k==j) continue;
                    if(D[i][k] != M && D[k][j] != M && D[i][j] > D[i][k] + D[k][j]){
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
        for(int i=0; i<D.length; i++){
            System.out.println(Arrays.toString(D[i]));
        }
    }
}
