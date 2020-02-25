package Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bac17825_주사위_윷놀이_G3 {
    static int Dise_arr[] = new int[10];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while(st.hasMoreTokens()) {
            Dise_arr[idx++] = Integer.parseInt(st.nextToken());
        }


        solution();

    }
    public static void solution(){
        makeGraph();

    }

    public static class makeGraph(){

    }

    public static class edge{
        int src;
        int dsc;
        int color;
        public edge(int src,int dsc) {
            this.src = src;
            this.dsc = dsc;
            this.color = color;
        }
    }

}

