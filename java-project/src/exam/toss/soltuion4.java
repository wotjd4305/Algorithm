package exam.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class soltuion4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");

        LinkedList<String> list = new LinkedList<>();


        for(int i=0; i<input.length; i++) {
            //없으면
            if (!list.contains(input[i])) {
                list.push(input[i]);

            }
            //중복된 애
            else{
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).equals(input[i])){
                        list.remove(j);
                        list.push(input[i]);
                    }
                }
            }

            int count =0;
            for(String s : list){
                System.out.print(s + " ");
                count++;
                if(count == 5) break;
            }
            System.out.println();
        }

    }
}
