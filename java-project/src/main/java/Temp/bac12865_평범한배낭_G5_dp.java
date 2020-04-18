package main.java.Temp;

import java.util.*;

public class bac12865_평범한배낭_G5_dp {
    public static void main(String args[]){
        ArrayList<Article> AL = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//물품수
        int K = sc.nextInt();//버틸무게

        int dp[] = new int[K+1];

        //무게와 가치
        for(int i = 1; i<=N; i++){
            AL.add(new Article(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(AL);
        for(Article a : AL){
            System.out.println(a.weight +"-" + a.value);
        }

        for(int n = 0; n<AL.size(); n++) {
            int c_w = AL.get(n).weight;
            int c_v = AL.get(n).value;

            for (int i = K; i >= c_w; i--) {
                dp[i] = Math.max(dp[i - c_w] + c_v, dp[i]);
            }
        }

        //1,2,3,4,5
        for(int i : dp){
            System.out.println(i);
        }
        System.out.println(dp[K]);

    }

    public static class Article implements Comparable<Article> {
        int weight;
        int value;
        Article(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Article o) {
            return this.weight - o.weight;
        }
    }
}
