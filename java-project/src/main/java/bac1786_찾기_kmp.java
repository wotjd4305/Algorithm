package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bac1786_찾기_kmp {

    static StringBuilder sb = new StringBuilder();
    static int cnt =0;

    static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {

            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    static void KMP(String parent, String pattern) {
        int[] table = getPi(pattern);

        int j = 0;
        for (int i = 0; i < parent.length(); i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    sb.append(i - pattern.length() + 2 +"\n");
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();
        KMP(parent, pattern);
        sb.insert(0, cnt+"\n");
        System.out.println(sb);
    }
}
