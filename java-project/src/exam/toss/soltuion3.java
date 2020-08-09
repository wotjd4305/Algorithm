/*
package exam.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class soltuion3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        HashMap<String, Integer> tempArr = new HashMap<>();
        String[] splited = input.split(" ");

        for(String s : splited){
            if(tempArr.containsKey(s)){
                System.out.println(tempArr.get(s).intValue());
            }
            else {
                tempArr.put(s,Function.compute(Integer.parseInt(s)));
                System.out.println(tempArr.get(s).intValue());
            }
        }

    }
}
*/
