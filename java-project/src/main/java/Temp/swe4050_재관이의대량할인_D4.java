package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swe4050_재관이의대량할인_D4 {

    static int T;
    static int N;
    static ArrayList<Integer> product;

    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int t=1; t<=T; t++){
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            product = new ArrayList<>();
            while(st.hasMoreTokens()){
                product.add(Integer.parseInt(st.nextToken()));
            }

            //정렬
            Collections.sort(product, Collections.reverseOrder());
            solution();

            System.out.println("#" + t + " " + answer);
        }

    }

    private static void solution() {
        for(int i =0; i<N; i++){
            if((i+1) % 3 != 0)
               answer += product.get(i);
           }
    }
}
