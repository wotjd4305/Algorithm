package TextBook;

import java.util.Scanner;

public class 소금배달2_백트래킹 {
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        gogosing(M,0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void gogosing(int M, int cnt){
        if(M<0){ //해가 없다.
            return;
        }
        else if(M==0){//해해
            /*if(min > cnt){
                min = cnt;
            }*/
            System.out.println(cnt==Integer.MAX_VALUE ? -1 : cnt);
            System.exit(0);
       }
        else{
            gogosing(M-5, cnt+1);
            gogosing(M-3, cnt+1);
        }
    }
}
