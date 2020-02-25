package main.java;

public class proString1 {

    public static String solution(String s) {
            String answer = "";
            String A[] = s.split(" ");
            int length = A.length;
            int count =0;

            for(String a: A)
            {
                count ++;
                for(int i =0; i<a.length(); i++)
                {
                    if(i==0 && (int) a.charAt(i) > 91)

                        answer += (char)((int) a.charAt(i) -32);
                    else if(i != 0 && ((int)a.charAt(i) > 64 && (int)a.charAt(i) < 91 ))
                        answer += (char)((int) a.charAt(i) + 32);
                    else
                        answer += a.charAt(i);
                }
                if(count == length)
                    break;
                answer += " ";
            }
            //32차이, Z가 90

            if (s.substring(s.length() - 1, s.length()).equals(" ")) {
                answer += " ";}

            return answer;
        }


    public static void main(String[] args) {

        String str= "3for the LicHking";

        System.out.println(solution(str));


    }



}
 
 
