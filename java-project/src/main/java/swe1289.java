import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swe1289 {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int T = 1; T <= t; T++) {
            String input_Buffer = sc.next();

           answer = solution(input_Buffer);



            System.out.println("#" + T + " " + answer);
        }
    }


    public static int solution(String input)
    {
        int count = 0;
        char last_char = input.charAt(input.length()-1);
        for(int i = input.length()-2; i>=0; i--)
        {
            if(input.charAt(i) == last_char)
                continue;
            else if(input.charAt(i) != last_char)
            {
                last_char = input.charAt(i);
                count++;
            }

        }

        //첫 숫자가 1이면 한번더 바꿔줘야하니 +1
        if(input.charAt(0) == '1')
        {
            count++;
        }

        return count;

    }
}


