package main.java.Temp2;

import java.util.Arrays;

public class proDP1 {
    static long ArrayDp[];

    public static void main(String[] args) {
        int n = 6;
        System.out.println(solution(n));
    }

    //규칙
    //6 - 8*4 + 5*2
    //5 - 5*4 + 3*2
    //3 - 2*4 + 1*2
    //1,1,2,3,5,8,13,21
  public static long solution(int n) {

        //계산없이 초장에 끝내기
        if(n==0)
            return 0;
        else if(n == 1)
            return 4;
        else if(n==2)
            return 6;



        //0으로 초기화
        ArrayDp = new long[n];
        ArrayDp[0] = 1;
        ArrayDp[1] = 1;

        makeArray(ArrayDp,n);

        return DP(n);
    }
    public static void makeArray(long[] a, int n)
    {
        for(int i=2; i<n; i++)
        {
            ArrayDp[i] = ArrayDp[i-2] + ArrayDp[i-1];
        }
    }

    public static long DP(int n)
    {
        return ArrayDp[n-1]*4 + ArrayDp[n-2]*2;
    }


}



