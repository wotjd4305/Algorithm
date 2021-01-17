package main.java.Temp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class swe4047 {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, Integer> Hm;
    static HashMap<String, Integer> Hm_For_Error;
    static ArrayList<String> AL = new ArrayList<>();

    public static void main(String[] args) {
        int T = sc.nextInt();
        String answer = "";

        for(int t=0; t<T; t++) {
            Hm = new HashMap<>();
            Hm_For_Error = new HashMap<>();

            AL.clear();
            answer = Solution();
            System.out.println("#" + (t+1) + " " + answer);
        }

    }

    public static String Solution()
    {
        String buffer = sc.next();
        int S = 13;
        int D = 13;
        int H = 13;
        int C = 13;

        SubStr(buffer);

        for( String str : AL)
        {
            if(Hm_For_Error.get(str) >=2)
                return "ERROR";
        }

        //에러가 없을 경우
    /*    S -= Hm.get("S");
        D -= Hm.get("D");
        H -= Hm.get("H");
        C -= Hm.get("C");
*/
        S -= Hm.getOrDefault("S",0);
        D -= Hm.getOrDefault("D",0);
        H -= Hm.getOrDefault("H",0);
        C -= Hm.getOrDefault("C",0);


        return (S + " " + D + " " + H + " " + C);
    }

    //1개면 0~2, 2개면 0~5
    public static void SubStr(String buffer)
    {
        //0, 3, 6, 9
        //0~2, 3~5, 6~8, 9~11
        for(int i=0; i<buffer.length()-2; i +=3)
        {
            AL.add(buffer.substring(i,i+3));
        }

        for(String str : AL)
        {
            Hm.put(str.substring(0,1), Hm.getOrDefault(str.substring(0,1),0) +1);
            Hm_For_Error.put(str, Hm_For_Error.getOrDefault(str,0) +1);
        }

    }

}

