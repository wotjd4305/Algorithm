package main.java;

import java.util.*;

public class swe1234 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        for (int T = 1; T <= 10; T++) {
            sc.next();
            String str = sc.next();
            String answer = "";
            char[] cArr = new char[str.length()];
            Stack<Character> Cstack = new Stack<>();


            //나눠담기
            for(int i =0; i<str.length(); i++)
            {
                cArr[i] = str.charAt(i);
            }


            Cstack.push(cArr[0]);
            for(int i=1; i<str.length(); i++)
            {
                try {
                    if(Cstack.empty())
                        Cstack.push(cArr[i]);
                    else if(Cstack.peek() == cArr[i])
                        Cstack.pop();
                    else
                        Cstack.push(cArr[i]);
                }catch (Exception e)
                {
                    Cstack.push(cArr[i]);
                    e.printStackTrace();
                }
            }

            while(!Cstack.empty())
                answer = Cstack.pop() + answer;
            System.out.println("#" + T + " " + answer);

        }
    }
}


