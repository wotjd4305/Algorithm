package main.java.Temp;

import java.util.Scanner;

public class Solution_SWEA_9760_D4 {
    static Scanner sc = new Scanner(System.in);
    static int T;
    static String[] SA;
    static int[] rank;
    //S D H C
    static int[] shape;

    static String answer = "";
    public static void main(String args[]){
        T = sc.nextInt();

        for(int i =0; i<T; i++){
            answer = "";
            shape = new int[4];
            rank = new int[14];
            SA = new String[5];
            answer = solution();
            System.out.println("#"+ (i+1)+ " " + answer);
        }
    }

    public static String solution(){
        input();
        if(St_Flush()) return "Straight Flush";
        if(Four_Kind()) return "Four of a Kind";
        if(Full_House()) return "Full House";
        if(Flush()) return "Flush";
        if(St()) return "Straight";
        if(Three_Kind()) return "Three of a kind";
        if(Two_pair()) return "Two pair";
        if(One_pair()) return "One pair";
        return "High card";
    }
    public static void input(){
        for(int i =0; i<5; i++) SA[i] = sc.next();
        for( String str : SA){
            if(str.charAt(0) == 'S') shape[0]++;
            if(str.charAt(0) == 'D') shape[1]++;
            if(str.charAt(0) == 'H') shape[2]++;
            if(str.charAt(0) == 'C') shape[3]++;

            if(str.charAt(1) <48 || str.charAt(1) > 58){
                if(str.charAt(1) == 'A') rank[1]++;
                if(str.charAt(1) == 'T') rank[10]++;
                if(str.charAt(1) == 'J') rank[11]++;
                if(str.charAt(1) == 'Q') rank[12]++;
                if(str.charAt(1) == 'K') rank[13]++;
            }
            else rank[Integer.parseInt(str.charAt(1) + "")]++;
        }

    }

    public static boolean isSerialRank(){
        boolean result = false;
        for(int i=1; i<=rank.length-5; i++){
            boolean flag = false;
            if(rank[i] != 1) continue;

            for(int j=1; j<5; j++){
                if(rank[i+j] == 1) {}
                else flag = true;
            }

            if(!flag){
                result = true;
                break;
            }
        }

        //로얄
        //1, 10,11,12,13
        if(rank[1] == 1 && rank[10] == 1
                && rank[11] == 1 && rank[12] == 1 && rank[13] ==1)
            result = true;

        return result;
    }

    public static boolean isSameShape(int count){
        boolean same_shape = false;

        for(int i =0; i<4; i++)
            if(shape[i] == count)
                same_shape = true;
        return same_shape;
    }

    public static boolean isSameRank(int count){
        boolean same_rank = false;

        for(int i =1; i<=13; i++)
            if(rank[i] == count)
                same_rank = true;

        return same_rank;
    }

    public static int isSameRank_cnt(int count){
        int cnt = 0;

        for(int i =1; i<=13; i++)
            if(rank[i] == count) cnt++;

            return cnt;
    }


    public static boolean St_Flush(){
        boolean result = false;

        if(isSameShape(5) && isSerialRank())
            result = true;

        return result;
    }

    public static boolean Four_Kind(){
        boolean result = false;

        if(isSameRank(4))
            result = true;

        return result;
    }
    public static boolean Full_House(){
        boolean result = false;
        if(isSameRank(3) && isSameRank(2))
            result = true;
        return result;
    }

    public static boolean Flush(){
        boolean result = false;
        if(isSameShape(5))
            result = true;
        return result;
    }
    public static boolean St(){
        boolean result = false;
        if(isSerialRank())
            result = true;

        return result;
    }
    public static boolean Three_Kind(){
        boolean result = false;
        if(isSameRank(3))
            result = true;

        return result;
    }
    public static boolean Two_pair(){
        boolean result = false;
        if(isSameRank_cnt(2) == 2)
            result = true;

        return result;
    }
    public static boolean One_pair(){
        boolean result = false;
        if(isSameRank(2))
            result = true;

        return result;
    }

}
