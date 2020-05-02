package main.java.Temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_정식이의은행업무_D4 {

    static String Arr_2[];
    static String Arr_3[];

    static int Arr_3_int[][];
    static int Arr_2_int[];

    static String leng_2;
    static String leng_3;
    static int sum_2;
    static int sum_3;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N입력과 초기화
        int T = Integer.parseInt(st.nextToken());

        for(int test =0; test<T; test++) {
            Arr_2 = new String[40]; // 0~39
            Arr_3 = new String[40];
            Arr_2_int = new int[40];
            Arr_3_int = new int[40][2];

            sum_2 = 0; sum_3 = 0;

            leng_2 = br.readLine();
            leng_3 = br.readLine();
            Arr_2 = leng_2.split("");
            Arr_3 = leng_3.split("");

            solution();
            System.out.println("#" + (test+1) + " " + sum_3);
        }

    }

    private static void solution() {

        for(int i =leng_2.length()-1; i>=0; i--){
            change_2(i);
            for(int j =leng_3.length()-1; j>=0; j--){
                change_3(j);
                cal(0);
                if(sum_2 == sum_3) return;
                cal(1);
                if(sum_2 == sum_3) return;
            }
        }
    }

    private static void change_2(int i) {

            for(int a =0; a<Arr_2.length; a++){
                Arr_2_int[a] = Integer.parseInt(Arr_2[a]);
            }
            if(Arr_2[i].equals("1")) Arr_2_int[i] = 0;
            else Arr_2_int[i] = 1;
    }

    private static void change_3(int j) {

            for(int a =0; a<Arr_3.length; a++){
                Arr_3_int[a][0] = Integer.parseInt(Arr_3[a]);
                Arr_3_int[a][1] = Integer.parseInt(Arr_3[a]);
            }
            if(Arr_3[j].equals("0")){
                Arr_3_int[j][0] = 2;
                Arr_3_int[j][1] = 1;
            }
            else if(Arr_3[j].equals("1")){
                Arr_3_int[j][0] = 2;
                Arr_3_int[j][1] = 0;
            }else{
                Arr_3_int[j][0] = 1;
                Arr_3_int[j][1] = 0;
            }
    }

    public static void cal(int col){
        sum_2 = 0; sum_3 = 0;
        for(int i = leng_2.length()-1; i>=0; i--){
            sum_2 += Arr_2_int[i] * Math.pow(2,leng_2.length()-i-1);
        }
        for(int i = leng_3.length()-1; i>=0; i--){
            sum_3 += Arr_3_int[i][col] * Math.pow(3,leng_3.length()-i-1);
        }
    }


}
