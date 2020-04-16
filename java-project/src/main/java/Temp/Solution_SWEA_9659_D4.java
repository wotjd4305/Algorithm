package main.java.Temp;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_SWEA_9659_D4 {

    static final int MOD = 998244353;
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;

    static int f[];
    static int m[];
    static ArrayList<Input> AL;
    static final Input Dummy = new Input(0,0,0);

    //1. f(x) = fa(x)+fb(x)
    //2  f(x) = a * fb(x)
    //3  f(x) = fa(x)*fb(x)

    public static void main(String[] args) {
        int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {

            N = sc.nextInt();
            //if N =4
            //0 ~ 4
            AL = new ArrayList<>();
            AL.add(Dummy);
            AL.add(Dummy);
            for(int i = 2; i<=N; i++){
                AL.add(new Input(sc.nextInt(),sc.nextInt(),sc.nextInt()));
            }

            //M 입력과 초기화
            M = sc.nextInt();
            m = new int[M];
            for(int i = 0; i<M; i++) m[i] = sc.nextInt();

            //M하나당 처리
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test + " ");
            for(int i =0; i<M; i++) {
                f = new int[N + 1];
                f[0] = 1; f[1] = m[i];
                for(int j=2; j<=N; j++){
                    switch (AL.get(j).i) {
                        case 1:
                            f[j] = (f[AL.get(j).a] + f[AL.get(j).b]) % MOD;
                            break;
                        case 2 :
                            f[j] = AL.get(j).a * f[AL.get(j).b] % MOD;
                            break;
                        case 3 :
                            f[j] = f[AL.get(j).a] * f[AL.get(j).b] % MOD;
                            break;
                    }
                }
                sb.append(f[N] + " ");
            }
            System.out.println(sb);
        }
    }

    public static class Input{
        int i;
        int a;
        int b;
        public Input(int i, int a, int b) {
            this.i = i;
            this.a = a;
            this.b = b;
        }
    }
}