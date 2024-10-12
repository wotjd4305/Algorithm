package Temp_2023;

import java.util.*;

public class L1_탐욕_체육복 {

    public static void main(String args[]) {
        int n = 5;
        int lost[] = {2,4};
        int reserve[] = {3};

        System.out.println(solution(n, lost, reserve));
    }


    public static int solution(int n, int[] lost, int[] reserve) {

        boolean[] lostBoolean = new boolean[n+1];
        for(int i : lost){
            lostBoolean[i] = true;
        }

        boolean[] reserveBoolean = new boolean[n+1];
        for(int i : reserve){
            reserveBoolean[i] = true;
        }

        boolean[] temp2 = reserveBoolean.clone();

        int idx = 0;
        for(boolean i : lostBoolean){
            if(reserveBoolean[idx] && i) {
                reserveBoolean[idx] = false;
            }
            idx++;
        }

        // 훔친 당했는 부류인데 여벌있으면 제거
        idx = 0;
        for(boolean i : temp2){
            lostBoolean[idx] = !i && lostBoolean[idx];
            idx++;
        }

        int result = n;
        idx = 0;
        for(boolean i : lostBoolean){
            // 잃어 버렸을 경우
            if(i){
                // 1이면 뒤만 확인
                if(idx == 1){
                    if(reserveBoolean[2]){
                        reserveBoolean[2] = false;
                    } else {
                        result--;
                    }
                }
                // n이면 앞만 확인
                else if(idx == n){
                    if(reserveBoolean[n-1]){
                        reserveBoolean[n-1] = false;
                    } else {
                        result--;
                    }
                }
                else {
                    if(reserveBoolean[idx-1]){
                        reserveBoolean[idx-1] = false;
                    } else if (reserveBoolean[idx+1]) {
                        reserveBoolean[idx+1] = false;
                    } else {
                        result--;
                    }
                }
            }
            idx++;
        }

        return result;
    }
}
