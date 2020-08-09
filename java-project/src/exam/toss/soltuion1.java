package exam.toss;

import main.java.bac3055_탈출_G5_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class soltuion1 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean answer = true;

        for(int i =0; i<input.length()-1; i++){
              if(input.charAt(i) == '1' && input.charAt(i+1) == '1'){
                    answer = false;
                    break;
                }
              else if(!(input.charAt(i) == '1' || input.charAt(i) == '2')){
                  answer = false;
                  break;
              }

        }
        //마지막꺼
        if(input.charAt(input.length()-1) == '1'){
            answer = false;
        }


        System.out.println(answer);

    }
}
