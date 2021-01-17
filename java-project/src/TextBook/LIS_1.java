package TextBook;

import java.util.Arrays;

public class LIS_1 {
    public static void main(String args[]) {
       int[] a = {3,2,6,4,5,1};
       int[] LIS = new int[a.length];
        int[] path = new int[a.length];


        for(int i =0; i<LIS.length;i++){
           LIS[i] = 1;//초기값(1개짜리수열)
           path[i] = -1; //나의 앞의 수열 숫자의 인덱스
            for(int j =0; j<i; j++){
               if(a[j] < a[i] && LIS[i] < LIS[j]+1){
                   LIS[i] = LIS[j] +1;
                   path[i] = j;
               }
           }
       }

       int maxLISIndex = 0;
       for(int i=0; i<LIS.length; i++){
           if (LIS[maxLISIndex] < LIS[i]) {
               maxLISIndex = i;
           }
       }

        System.out.println("최장 증가 수열 갯수 길이 = " + LIS[maxLISIndex]);
        System.out.println(Arrays.toString(path));

        String result = "";
        //역추적이라 앞임, 계속 부모로올라감
        for(int i = maxLISIndex; i != -1; i= path[i] ){
            result = a[i] + " " + result;
        }


    }
}
