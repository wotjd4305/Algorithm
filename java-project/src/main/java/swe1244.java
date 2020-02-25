package main.java;

import java.util.*;

public class swe1244 {
    static Scanner sc = new Scanner(System.in);
    static String answer = "";
    static int max = 0;
    static int possibleMax =0;

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int T = 1; T <= t; T++) {
            String str = sc.next();
            int exN = sc.nextInt();
            answer = "";
            max =0;
            possibleMax = findMax(str);

            dfs(str, 0,exN);
            answer = ""+max;


            System.out.println("#" + T + " " + answer);
        }
    }

    public static int findMax(String str)
    {
        ArrayList<Integer> a = new ArrayList<>();
        String buffer= "";
        for(int i=0; i<str.length(); i++)
        {
            a.add(Integer.parseInt( "" + str.charAt(i)));
        }
        Collections.sort(a,Collections.reverseOrder());

        for(int i : a)
            buffer += i  +"";

        return Integer.parseInt(buffer);
    }


    public static void dfs(String str,int cnt, int exN)
    {
        String buffer = "";

        if((str.length()/2 < cnt) && ((cnt % 2) == 0))
        {
            max = Math.max(max, Integer.parseInt(str));
            return;
        }


        if(cnt == exN)
        {
            //System.out.print("MAX");
            max = Math.max(max, Integer.parseInt(str));
            return;
        }

        //뱅뱅돌때
        if(max == Integer.parseInt(str))
        {
            return;
        }

        //가능한 최대값일떄
        if(possibleMax == max)
        {
            return;
        }

        for(int i =0; i<str.length(); i++)
        {
            for(int j=i+1; j<str.length(); j++) {
                if(i==j)
                    break;
                buffer = swap(str, i, j);
                dfs(buffer, cnt+1, exN);
            }
        }

    }

    public static String swap(String str, int p1, int p2)
    {
        String buffer = "";
        //System.out.print(" swap - ");
        for(int i =0; i<str.length(); i++)
        {
            //바뀌는 부분은 냅두고
            if(i==p1)
            {
                buffer += str.charAt(p2);
                continue;
            }
            if(i==p2)
            {
                buffer += str.charAt(p1);
                continue;
            }
            buffer += str.charAt(i);

        }
//        System.out.print("버퍼값" + buffer);
        return buffer;
    }
}


